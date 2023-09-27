package utils.integration.fimi;

import utils.integration.fimi.entity.User;
import utils.integration.fimi.requests.GetCMSArchiveRq;
import utils.integration.fimi.requests.InitSessionRq;
import utils.integration.fimi.requests.LogoffRq;
import utils.integration.fimi.requests.LogonRq;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


public class SOAPClientSAAJ {
    private static final String TEST_CRED = "DB_TEST2";

    public static String getDynamicCodeByHisNumber(String login, String numberOfCode) {
        String code = "";
        try {
            SOAPMessage initSessionResponse = initSessionRequest();
            var session = SOAPParser.getValueFromBodyXML(initSessionResponse, 0);
            SOAPMessage loginResponse = loginRequest(session,
                    SOAPParser.getAttributeValueFromResponse(initSessionResponse, 0));
            SOAPMessage getCMSArchiveResponse = getCMSArchiveRequest(session,
                    SOAPParser.getAttributeValueFromResponse(loginResponse, 0), login);
            code = SOAPParser.getValueByTagName(getCMSArchiveResponse, "m0:Message", numberOfCode);
            logout(session, SOAPParser.getAttributeValueFromResponse(getCMSArchiveResponse, 0));

        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return code;
    }

    private static void logout(String session, String challenge) {
        var password = TripleDes.get3DesFimiPassword(TEST_CRED, challenge);
        var user = new User(TEST_CRED, password, session);
        new LogoffRq().callSoapWebService(user);
    }

    private static SOAPMessage getCMSArchiveRequest(String session, String challenge, String login) throws SOAPException {
        var password = TripleDes.get3DesFimiPassword(TEST_CRED, challenge);
        var user = new User(TEST_CRED, password, session, null, login);
        return new GetCMSArchiveRq().callSoapWebService(user);
    }

    private static SOAPMessage loginRequest(String session, String challenge) throws SOAPException {
        var password = TripleDes.get3DesFimiPassword(TEST_CRED, challenge);
        var user = new User(TEST_CRED, password, session);
        return new LogonRq().callSoapWebService(user);
    }

    private static SOAPMessage initSessionRequest() throws SOAPException {
        var user = new User();
        user.setClerk(TEST_CRED);
        return new InitSessionRq().callSoapWebService(user);
    }
}

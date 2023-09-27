package utils.integration.fimi.requests;

import utils.integration.fimi.entity.User;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class LogonRq extends InitSoapRq {

    @Override
    public SOAPMessage callSoapWebService(User user) {
        try {
            var soapConnection = createSoapConnect();
            var soapMessage = formSoapEnvelope(formHeadersForReq(SOAP_URL + "/LogonRq"), user);
            soapMessage.saveChanges();
            return soapConnection.call(soapMessage, SOAP_URL);
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SOAPConnection createSoapConnect() throws SOAPException {
        var soapConnectionFactory = SOAPConnectionFactory.newInstance();
        return soapConnectionFactory.createConnection();
    }

    private SOAPMessage formSoapEnvelope(SOAPMessage soapMessage, User user) throws SOAPException {
        var soapBody = initBodyEnvelope(soapMessage).getBody();
        var soapBodyElem = soapBody.addChildElement("LogonRq", myNamespace);
        var soapBodyReqElement = soapBodyElem.addChildElement("Request", myNamespace);
        soapBodyReqElement.addAttribute(new QName("Product"), "FIMI");
        soapBodyReqElement.addAttribute(new QName("Clerk"), user.getClerk());
        soapBodyReqElement.addAttribute(new QName("Password"), user.getPassword());
        soapBodyReqElement.addAttribute(new QName("Session"), user.getSession());
        soapBodyReqElement.addAttribute(new QName("Ver"), "16.16");

        return soapMessage;
    }
}

package utils.integration.fimi.requests;

import utils.integration.fimi.entity.User;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

public class InitSessionRq extends InitSoapRq {

    @Override
    public SOAPMessage callSoapWebService(User user) {
        try {
            var soapConnection = createSoapConnect();
            var soapMessage = formSoapEnvelope(formHeadersForReq(SOAP_URL + "/InitSessionRq"), user);
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
        SOAPBody soapBody = initBodyEnvelope(soapMessage).getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("InitSessionRq", myNamespace);
        SOAPElement soapBodyReqElement = soapBodyElem.addChildElement("Request", myNamespace);
        soapBodyReqElement.addAttribute(new QName("Product"), "FIMI");
        soapBodyReqElement.addAttribute(new QName("Clerk"), user.getClerk());
        soapBodyReqElement.addAttribute(new QName("Ver"), "16.16");

        soapBodyReqElement.addChildElement("NeedDicts", myNamespace1)
                .addTextNode("0");
        soapBodyReqElement.addChildElement("AllVendors", myNamespace1)
                .addTextNode("0");
        soapBodyReqElement.addChildElement("AvoidSession", myNamespace1)
                .addTextNode("0");

        return soapMessage;
    }
}

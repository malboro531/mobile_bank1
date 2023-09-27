package utils.integration.fimi.requests;

import utils.integration.fimi.entity.User;

import javax.xml.soap.*;


public abstract class InitSoapRq {
    protected static final String SOAP_URL = "http://172.22.250.89:51030";
    protected static final String myNamespace = "fimi";
    protected static final String myNamespace1 = "fimi1";
    private static final String myNamespaceURI = "http://schemas.compassplus.com/two/1.0/fimi.xsd";
    private static final String myNamespaceURITypes = "http://schemas.compassplus.com/two/1.0/fimi_types.xsd";
    private static final String schemeURI = "http://www.w3.org/2003/05/soap-envelope";

    public abstract SOAPMessage callSoapWebService(User user);

    protected SOAPMessage formHeadersForReq(String soapAction) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("Accept-Encoding", "gzip,deflate");
        headers.addHeader("SOAPAction", soapAction);
        headers.addHeader("Content-Type", "application/soap+xml;charset=UTF-8");

        return soapMessage;
    }

    protected SOAPEnvelope initBodyEnvelope(SOAPMessage soapMessage) throws SOAPException {
        var SOAP_PREFIX = "soap";
        var soapPart = soapMessage.getSOAPPart();
        var envelope = soapPart.getEnvelope();

        envelope.removeNamespaceDeclaration(envelope.getPrefix());
        envelope.setPrefix(SOAP_PREFIX);
        soapMessage.getSOAPHeader().setPrefix(SOAP_PREFIX);
        soapMessage.getSOAPBody().setPrefix(SOAP_PREFIX);
        envelope
                .addNamespaceDeclaration(SOAP_PREFIX, schemeURI)
                .addNamespaceDeclaration(myNamespace, myNamespaceURI)
                .addNamespaceDeclaration(myNamespace1, myNamespaceURITypes);

        return envelope;
    }
}

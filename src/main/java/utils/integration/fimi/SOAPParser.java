package utils.integration.fimi;

import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SOAPParser {
    public static String getValueFromBodyXML(SOAPMessage soapResponse, int index) throws SOAPException {
        return soapResponse
                .getSOAPBody()
                .getTextContent()
                .trim()
                .split("\\s+")[index];
    }

    public static String getAttributeValueFromResponse(SOAPMessage soapResponse, int index) throws SOAPException {
        var responseList = soapResponse.getSOAPPart().getEnvelope().getBody().getElementsByTagName("Response").item(0);
        return responseList.getAttributes().item(index).getTextContent();
    }

    public static String getValueByTagName(SOAPMessage soapResponse, String tagName, String numberOfCode) throws SOAPException {
        var nodesList = soapResponse.getSOAPBody().getElementsByTagName(tagName);
        return getCodeByHisNumber(nodesList, numberOfCode);
    }

    private static String getCodeByHisNumber(NodeList listOfMessages, String numberOfCode) {
        for (var i = 0; i < listOfMessages.getLength(); i++) {
           var message = listOfMessages.item(i).getTextContent();
           if (isEqualsNumberOfCodeFromMessageAndNumberFromInput(message, numberOfCode)) {
                return getCodeFromMessage(message);
           }
        }
        return "0000";
    }

    private static boolean isEqualsNumberOfCodeFromMessageAndNumberFromInput(String message, String numberOfCode) {
        var codeSplit = message.split("Код ")[1];
        return codeSplit.substring(1, 2).equals(numberOfCode);
    }

    private static String getCodeFromMessage(String message) {
        var code = new StringBuilder();
        Matcher matcher = (Pattern.compile("[\\d{4}]")).matcher(message);

        while (matcher.find()) {
            code.append(message, matcher.start(), matcher.end());
        }
        return code.substring(1);
    }
}

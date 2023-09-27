package utils.integration.fimi;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TripleDes {

    public static void main(String... args) {
        String password = "DB_TEST2";
        String nextChallenge = "E0A405F4";

        System.out.println(get3DesFimiPassword(password, nextChallenge));
    }

    public static String get3DesFimiPassword(String password, String challenge) {
        var passwordHash = "";
        char paddingValue = ' ';

        String password16 = paddingString(password.toUpperCase(), 16, paddingValue);
        String password8 = paddingString(password.toUpperCase(), 8, paddingValue);

        try {
            var key = DES_ECB_Encode(
                    getHex(password16.getBytes()),
                    getHex(password8.getBytes())
            );

            passwordHash = DES_ECB_Encode(key, getHex(challenge.getBytes())).substring(0, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return passwordHash;
    }

    private static String DES_ECB_Encode(String key, String data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher c = Cipher.getInstance("DESede/ECB/NoPadding");

        byte[] keyBytes = BytesEncode(key);
        SecretKeySpec pKey = new SecretKeySpec(keyBytes, "DESede");

        c.init(Cipher.ENCRYPT_MODE, pKey);
        byte[] dataBytes = BytesEncode(data);
        byte[] output = c.doFinal(BytesEncode(data));

        return getHex(output);
    }

    private static byte[] BytesEncode(String encoded) {
        encoded = encoded.toUpperCase();
        encoded = encoded.replace(" ", "");

        if (encoded.length() == 16) {
            encoded += encoded += encoded;
        } else if (encoded.length() == 32) {
            encoded += encoded.substring(0, 16);
        }

        byte[] result = new byte[encoded.length() / 2];
        char[] enc = encoded.toUpperCase().toCharArray();

        String curr = "";

        for (int i = 0; i < encoded.length(); i += 2) {
            curr = encoded.substring(i, i + 2);
            if (i == 0) {
                result[i] = ((byte) Integer.parseInt(curr, 16));
            } else {
                result[i / 2] = ((byte) Integer.parseInt(curr, 16));
            }
        }

        return result;
    }

    private static String paddingString(String string, int length, char paddingValue) {
        StringBuilder paddingString = new StringBuilder();

        if (string.length() > length) {
            return string.substring(0, length);
        }

        if (string.length() < length) {
            while (paddingString.length() < (length - string.length())) {
                paddingString.append(paddingValue);
            }
        }

        return string + paddingString;
    }

    private static byte[] bytesArrayXor(byte[] arrayFirst, byte[] arraySecond) {
        byte[] result = new byte[arrayFirst.length];

        for (int i = 0; i < arrayFirst.length; i++) {
            result[i] = (byte) (arrayFirst[i] ^ arraySecond[i]);
        }

        return result;
    }

    private static String getHex(byte[] bytesKey) {
        StringBuilder key = new StringBuilder();

        for (byte b : bytesKey) {
            key.append(String.format("%02X", b));
        }

        return key.toString();
    }

}

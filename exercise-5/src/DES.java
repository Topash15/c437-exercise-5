// Encode and decode Are you ENJOYING your STAY in our TOWN??

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {

    public static void main (String[] args) throws Exception {
        String Message = "Are you ENJOYING your STAY in our TOWN??";
        System.out.println("DES Original Message: " + Message);
        
        // Generate a DES Key
        String secretKeyString = "mySecret";
        DESKeySpec desKeySpec = new DESKeySpec(secretKeyString.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] cipherTextArray = cipher.doFinal(Message.getBytes());
        String cipherString = Base64.getEncoder().encodeToString(cipherTextArray);
        System.out.println("DES Encrypted message: " + cipherString);
 
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte [] decryptedString = cipher.doFinal(Base64.getDecoder().decode(cipherString));
        System.out.println("DES Decrypted Message: " + new String(decryptedString));
    }
}

// Encode and decode Are you ENJOYING your STAY in our TOWN??

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class ThreeDES {

    public static void main (String[] args) throws Exception {
        String Message = "Are you ENJOYING your STAY in our TOWN??";
        System.out.println("Original Message: " + Message);
        
        // Generate a 3DES Key
        String secretKeyString = "mySecretKey1111111111111";
        DESedeKeySpec desedeKeySpec = new DESedeKeySpec(secretKeyString.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("TripleDES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desedeKeySpec);

        Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] cipherTextArray = cipher.doFinal(Message.getBytes());
        String cipherString = Base64.getEncoder().encodeToString(cipherTextArray);
        System.out.println("Encrypted message: " + cipherString);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte [] decryptedString = cipher.doFinal(Base64.getDecoder().decode(cipherString));
        System.out.println("Decrypted Message: " + new String(decryptedString));

    }
}

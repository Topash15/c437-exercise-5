// Encode and decode Are you ENJOYING your STAY in our TOWN??

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES {

    public static void main (String[] args) throws Exception {
        String Message = "Are you ENJOYING your STAY in our TOWN??";
        System.out.println("AES Original Message: " + Message);
        
        // Generate a AES Key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);

        // Secret Key
        SecretKey secretKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] cipherTextArray = cipher.doFinal(Message.getBytes());
        String cipherString = Base64.getEncoder().encodeToString(cipherTextArray);
        System.out.println("AES Encrypted message: " + cipherString);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte [] decryptedString = cipher.doFinal(Base64.getDecoder().decode(cipherString));
        System.out.println("AES Decrypted Message: " + new String(decryptedString));

    }
}

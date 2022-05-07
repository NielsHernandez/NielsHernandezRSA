
package nielshernandezrsa;import java.io.IOException;
import java.io.UnsupportedEncodingException;import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;import javax.crypto.NoSuchPaddingException;
/**
 *
 * @author niels
 */
public class NielsHernandezRSA {/**principal*/
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, NoSuchProviderException {
        String str = "melvin cali";
        System.out.println("\nTexto a cifrar:");
        System.out.println(str);
        RSA rsa = new RSA();
        //gen par of keys
        //suportaclaves de 512, 1024, 2048 y 4096 bits...
        rsa.genKeyPair(512);
     
        String file_private = "/tmp/rsa.pri";
        String file_public = "/tmp/rsa.pub";
        
        //Las guardamos asi podemos usarlas despues
        //a lo largo del tiempo
        rsa.saveToDiskPrivateKey("/tmp/rsa.pri");
        rsa.saveToDiskPublicKey("/tmp/rsa.pub");
        
        //Ciframos y e imprimimos, el texto cifrado
        //es devuelto en la variable secure
        String secure = rsa.Encrypt(str);
        
        System.out.println("\nCifrado:");
        System.out.println(secure);
        
                
        String unsecure = rsa.Decrypt(secure);
        
        //Imprimimos
        System.out.println("\nDescifrado:");
        System.out.println(unsecure);   
        
    }
    
}

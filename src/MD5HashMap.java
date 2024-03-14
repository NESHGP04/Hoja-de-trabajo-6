import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashMap implements IHash{
    
    @Override
    public String hash(String input){
        try {
            // Obtener la instancia de MessageDigest con el algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calcular el hash MD5
            byte[] hashedBytes = md.digest(input.getBytes());

            // Convertir el arreglo de bytes a una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            String md5Hash = sb.toString();

            return md5Hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}


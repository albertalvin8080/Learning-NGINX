import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class GenerateSecureLink {
    public static void main(String[] args)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
        String secret = "1234567";
        String uri = "/files/image.png";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2024-10-10";
        Date date = dateFormat.parse(dateString);
        long expires = date.getTime() / 1000;

        String secureLink = generateSecureLink(secret, uri, expires);
        System.out.println(secureLink);
    }

    public static String generateSecureLink(String secret, String uri, long expires)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String formattedStr = String.format("%s:%s:%d", secret, uri, expires);

        byte[] md5Bytes = MessageDigest.getInstance("MD5").digest(formattedStr.getBytes("UTF-8"));
        String md5String = Base64.getUrlEncoder().withoutPadding().encodeToString(md5Bytes);

        return String.format("%s?md5=%s&expires=%d", uri, md5String, expires);
    }
}

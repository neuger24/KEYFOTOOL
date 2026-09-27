package util;
import java.security.SecureRandom;

public class KeyGen {

    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();


    public static String generateProductKey() {
        StringBuilder sb = new StringBuilder(29);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int index = RANDOM.nextInt(ALPHANUMERIC.length());
                sb.append(ALPHANUMERIC.charAt(index));
            }

            if (i < 4) {
                sb.append("-");
            }
        }

        return sb.toString();
    }


}
package util;
// 25 caratteri ex: xxxxx-xxxxx-xxxxx-xxxxx-xxxxx
public class KeyGen {

    public static String generaKey() {
        String key;
        String c;

        for (int i =0; i<5; i++){


        }



    }

    private String StringaR(String s){
        char a;
        int m = 0;
        for(int i =0; i<5; i++) {

            int n = (int) (Math.random() * 1);
            if (n == 0) {
                m = (int) (Math.random() * 10);
                a = (char) m;
                s.concat(String.valueOf(a));
            }else{
                s.concat(String.valueOf(carattereR(a)));
            }
        }
        return s;
    }

    private char carattereR(char a) {

    }


}

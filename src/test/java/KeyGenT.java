// 25 caratteri ex: xxxxx-xxxxx-xxxxx-xxxxx-xxxxx
public class KeyGenT {

    public static String generaKey() {
        String key = "";
        String c= "";

        for (int i =0; i<5; i++){
            c=StringaR();
            key.concat(c);
            if(i!=4);
                key.concat("-");

        }
        return key;
    }

    private static String StringaR(){
        String s = "";
        char a;
        int m = 0;
        for(int i =0; i<5; i++) {

            int n = (int) (Math.random() * 1);
            if (n == 0) {
                m = (int) (Math.random() * 10);
                a = (char) m;
                s.concat(String.valueOf(a));
            }else{
                a=carattereR();
                s.concat(String.valueOf(a));
            }
        }
        return s;
    }

    private static char carattereR() {
        char a;
        int n = (int) (Math.random() * 27);
        switch (n){
            case 1:
                a='A';
                break;
            case 2:
                a='B';
                break;
            case 3:
                a = 'C';
                break;
            case 4:
                a = 'D';
                break;
            case 5:
                a = 'E';
                break;
            case 6:
                a = 'F';
                break;
            case 7:
                a = 'G';
                break;
            case 8:
                a = 'H';
                break;
            case 9:
                a = 'I';
                break;
            case 10:
                a = 'J';
                break;
            case 11:
                a = 'K';
                break;
            case 12:
                a = 'L';
                break;
            case 13:
                a = 'M';
                break;
            case 14:
                a = 'N';
                break;
            case 15:
                a = 'O';
                break;
            case 16:
                a = 'P';
                break;
            case 17:
                a = 'Q';
                break;
            case 18:
                a = 'R';
                break;
            case 19:
                a = 'S';
                break;
            case 20:
                a = 'T';
                break;
            case 21:
                a = 'U';
                break;
            case 22:
                a = 'V';
                break;
            case 23:
                a = 'W';
                break;
            case 24:
                a = 'X';
                break;
            case 25:
                a = 'Y';
                break;
            case 26:
                a = 'Z';
                break;
            default:
                a='0';
                break;
        }
        return a;


    }


}

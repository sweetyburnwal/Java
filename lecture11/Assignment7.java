package lecture11;

/**
 * Created by piyush0 on 27/06/17.
 */
public class Assignment7 {
    public static void main(String[] args) {
        printCodes("1123","");
    }

    public static int countTwins(String str) {
        if (str.length() < 3) {
            return 0;
        }

        String chk = str.substring(0, 3);

        if (chk.charAt(0) == chk.charAt(2)) {
            return 1 + countTwins(str.substring(1));
        } else {
            return countTwins(str.substring(1));
        }
    }

    public static int countAAA(String str) {

        if (str.length() < 3) {
            return 0;
        }

        String chk = str.substring(0, 3);

        if (chk.equals("aaa")) {
            return 1 + countAAA(str.substring(1));
        } else {
            return countAAA(str.substring(1));
        }

    }

    public static int countAAAnO(String str) {
        if (str.length() < 3) {
            return 0;
        }

        String chk = str.substring(0, 3);

        if (chk.equals("aaa")) {
            return 1 + countAAAnO(str.substring(3));
        } else {
            return countAAAnO(str.substring(1));
        }
    }

    public static void printCodes(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // first recursive call
        char cc = str.charAt(0);
        int cn = cc - '0';
        char fc = (char) (cn + 'a' - 1);
        printCodes(str.substring(1), ans + fc);

        if (str.length() > 1) {
            //second recursive call
            char nc = str.charAt(1);
            int cn2 = nc - '0';
            cn2 = cn * 10 + cn2;
            char sc = (char) (cn2 + 'a' - 1);
            if (cn2 <= 26) {
                printCodes(str.substring(2), ans + sc);
            }
        }

    }

}

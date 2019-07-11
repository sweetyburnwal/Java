package lecture9;

/**
 * Created by piyush0 on 24/06/17.
 */
public class Assignment7 {

    public static void main(String[] args) {
//        String str = "1234";
//        System.out.println(num(str, str.length() - 1, 1));

//        String s1 = "abcd";
//        String s2 = "dcbaa";
//        System.out.println(isReverse(s1, s2, 0, s2.length() - 1));

//        String str = "abcqa";
//        System.out.println(isPalindrome(str, 0, str.length() - 1));

//        System.out.println(removeDuplicates("hhelloo"));
        String str = "xbexexdexed";
//        System.out.println(moveXtoEnd(str, 0));

        String s = "abchiahi";
        System.out.println(removeHi(s));
    }

    public static int num(String str, int ei, int tenPower) {

        if (ei < 0) {
            return 0;
        }

        char cc = str.charAt(ei);
        int cn = cc - '0';

        int recResult = num(str, ei - 1, tenPower * 10);

        return recResult + tenPower * cn;

    }

    public static boolean isReverse(String s1, String s2, int start1, int end2) {

        if (end2 < 0 || start1 >= s1.length()) {
            return s1.length() == s2.length();
        }

        if (s1.charAt(start1) != s2.charAt(end2)) {
            return false;
        } else {
            return isReverse(s1, s2, start1 + 1, end2 - 1);
        }
    }

    public static boolean isPalindrome(String s1, int left, int right) {

        if (left > right) {
            return true;
        }

        if (s1.charAt(left) != s1.charAt(right)) {
            return false;
        } else {
            return isPalindrome(s1, left + 1, right - 1);
        }

    }

    public static String duplicates(String str) {

        if (str.length() < 2) {
            return str;
        }

        char cc = str.charAt(0);
        char nc = str.charAt(1);

        String ros = str.substring(1);

        String recResult = duplicates(ros);

        if (cc == nc) {
            return cc + "*" + recResult;
        } else {
            return cc + recResult;
        }

    }

    public static String removeDuplicates(String str) {

        if (str.length() < 2) {
            return str;
        }

        char cc = str.charAt(0);
        char nc = str.charAt(1);

        String ros = str.substring(1);
        String recResult = removeDuplicates(ros);

        if (cc == nc) {
            return recResult;
        } else {
            return cc + recResult;
        }

    }

    public static String moveXtoEnd(String str, int count) {

        if (str.length() == 0) {
            String baseResult = "";

            for (int i = 0; i < count; i++) {
                baseResult += "x";
            }

            return baseResult;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        if (cc == 'x') {
            String recResult = moveXtoEnd(ros, count + 1);
            return recResult;

        } else {
            String recResult = moveXtoEnd(ros, count);
            return cc + recResult;
        }

    }

    public static int countHi(String str) {

        if (str.length() < 2) {
            return 0;
        }

        String chk = str.substring(0, 2);

        if (chk.equals("hi")) {

            String ros = str.substring(2);
            int recResult = countHi(ros);
            return 1 + recResult;

        } else {
            String ros = str.substring(1);
            int recResult = countHi(ros);

            return recResult;
        }

    }

    public static String removeHi(String str) {

        if (str.length() < 2) {
            return str;
        }

        String chk = str.substring(0, 2);
        char cc = str.charAt(0);

        if (chk.equals("hi")) {
            String ros = str.substring(2);
            String recResult = removeHi(ros);
            return recResult;

        } else {
            String ros = str.substring(1);
            String recResult = removeHi(ros);
            return cc + recResult;
        }

    }

    public static int countHiButNotHit(String str) {

        if (str.length() < 3) {
            if (str.equals("hi")) {
                return 1;
            } else {
                return 0;
            }
        }

        String chk = str.substring(0, 2);

        if (chk.equals("hi")) {

            if (str.charAt(2) == 't') {
                return countHiButNotHit(str.substring(1));
            } else {
                return 1 + countHiButNotHit(str.substring(1));
            }

        } else {
            return countHiButNotHit(str.substring(1));
        }

    }

}

package lecture5;

import java.util.Scanner;

/**
 * Created by piyush0 on 15/06/17.
 */
public class StringQuestions {
    public static void main(String[] args) {
//        Scanner scrn = new Scanner(System.in);
//        String str = scrn.next();
//        System.out.println("The string you entered is " + str);
////        printCharsInNewLine("Hello World ");


//        System.out.println(isPalindrome("nitun"));
//        printAllSubstrings("abcd");
        System.out.println(countPalindromicSubstrings("abba"));

    }

    public static void printCharsInNewLine(String str) {

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void printAllSubstrings(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }

    }

    public static boolean isPalindrome(String str) {


        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;

    }

    public static int countPalindromicSubstrings(String str) {
        int counter = 0;


        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {

                // 1 valid substring str.substring(i,j)
                if (isPalindrome(str.substring(i, j))) {
                    counter++;
                }


            }
        }

        return counter;
    }

    public static String toggle(String str) {
        return "";
    }
}

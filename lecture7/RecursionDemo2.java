package lecture7;

import lecture4.ArraysDemo;
import lecture4.ArraysQuestions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyush0 on 18/06/17.
 */
public class RecursionDemo2 {

    public static void main(String[] args) {
//        int[] arr = {2, 342, 1, 23, -1, 23, -23};
//        bubbleSort(arr, 0, 1);
//        ArraysQuestions.display(arr);

//        System.out.println(getSSwASCII("ab"));

//        System.out.println(getKeypadCombinations("12"));

//        printSS("abc", "");

//        printSSwAscii("ab", "");

//        printKeypadCombintations("129", "");
        Scanner scrn = new Scanner(System.in);

        int n = scrn.nextInt();
        scrn.nextLine();
        String s1 = scrn.nextLine();

        System.out.println(n);
        System.out.println(s1);
    }

    public static void selectionSort(int[] arr, int i, int j) {

        if (i == arr.length) {
            return;
        }


        if (j == arr.length) {
            selectionSort(arr, i + 1, i + 2);
            return;
        }


        if (arr[i] > arr[j]) {
            ArraysDemo.swap(arr, i, j);
        }

        selectionSort(arr, i, j + 1);

    }

    public static void bubbleSort(int[] arr, int i, int j) {

        if (i == arr.length) {
            return;
        }

        if (j == arr.length - i - 1) {
            bubbleSort(arr, i + 1, 0);
            return;
        }


        if (arr[j] > arr[j + 1]) {
            ArraysDemo.swap(arr, j, j + 1);
        }

        bubbleSort(arr, i, j + 1);
    }

    public static ArrayList<String> getSS(String str) {

        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> recResult = getSS(ros);
        ArrayList<String> myResult = new ArrayList<>();

        for (int i = 0; i < recResult.size(); i++) {
            String recString = recResult.get(i);
            myResult.add(recString);
        }

        for (int i = 0; i < recResult.size(); i++) {
            String recString = recResult.get(i);
            myResult.add(recString + cc);
        }

        return myResult;

    }

    public static ArrayList<String> getSSwASCII(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> recResult = getSSwASCII(ros);
        ArrayList<String> myResult = new ArrayList<>();

        for (int i = 0; i < recResult.size(); i++) {
            String recString = recResult.get(i);
            myResult.add(recString);
        }

        for (int i = 0; i < recResult.size(); i++) {
            String recString = recResult.get(i);
            myResult.add(recString + cc);
        }

        int num = cc;

        for (int i = 0; i < recResult.size(); i++) {
            String recString = recResult.get(i);
            myResult.add(recString + num);
        }

        return myResult;

    }

    public static ArrayList<String> getKeypadCombinations(String str) { // "129"
        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }


        char cc = str.charAt(0); // '1'
        String ros = str.substring(1); // "29"

        ArrayList<String> recResult = getKeypadCombinations(ros); // keypad combinations of "29"

        int correspondingNumber = cc - '0'; // 1

        String code = getCode(correspondingNumber); // "abc"

        ArrayList<String> myResult = new ArrayList<>();

        for (int i = 0; i < recResult.size(); i++) {

            String recString = recResult.get(i);

            for (int j = 0; j < code.length(); j++) {
                myResult.add(code.charAt(j) + recString); // charAt(j) will traverse a , b , c
            }

        }


        return myResult;

    }

    public static String getCode(int num) {
        if (num == 1) {
            return "abc";
        } else if (num == 2) {
            return "def";
        } else if (num == 3) {
            return "ghi";
        } else if (num == 4) {
            return "jkl";
        } else if (num == 5) {
            return "mno";
        } else if (num == 6) {
            return "pqr";
        } else if (num == 7) {
            return "stu";
        } else if (num == 8) {
            return "vwx";
        } else if (num == 9) {
            return "yz";
        } else {
            return "";
        }
    }


    public static void printSS(String question, String answer) {

        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }

        char cc = question.charAt(0);
        String ros = question.substring(1);

        printSS(ros, answer + cc); // ch says yes

        printSS(ros, answer); // ch says no

    }

    public static void printSSwAscii(String question, String answer) {
        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }

        char cc = question.charAt(0);

        int num = cc;
        String ros = question.substring(1);

        printSSwAscii(ros, answer);

        printSSwAscii(ros, answer + cc);

        printSSwAscii(ros, answer + num);
    }

    public static void printKeypadCombintations(String ques, String ans) { // "149"

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char cc = ques.charAt(0); //'1'
        String ros = ques.substring(1); // "49"

        int cn = cc - '0'; // 1
        String code = getCode(cn); // "abc"

        for (int i = 0; i < code.length(); i++) {
            printKeypadCombintations(ros, ans + code.charAt(i));
        }

//        printKeypadCombintations(ros, ans + code.charAt(0)); // a
//        printKeypadCombintations(ros, ans + code.charAt(1)); // b
//        if (cc != '9') {
//            printKeypadCombintations(ros, ans + code.charAt(2)); // c
//        }
    }


}

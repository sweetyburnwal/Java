package lecture8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyush0 on 22/06/17.
 */
public class RecursionDemo3 {

    public static void main(String[] args) {
        printPerms2("kqw,", "");
    }

    public static void printLexico(int end, int curr) {

        if (curr > end) {
            return;
        }

        System.out.println(curr);

        int start = 0;
        if (curr == 0) {
            start++;
        }

        for (int i = start; i <= 9; i++) {
            printLexico(end, curr * 10 + i);

        }

    }

    public static ArrayList<String> getPerms(String str) {

        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }


        char cc = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> recResult = getPerms(ros);
        ArrayList<String> myResult = new ArrayList<>();

        for (int i = 0; i < recResult.size(); i++) {
            String recString = recResult.get(i);

            for (int j = 0; j <= recString.length(); j++) {
                String myString = recString.substring(0, j) + cc + recString.substring(j);
                myResult.add(myString);
            }

        }


        return myResult;
    }

    public static void printPerms(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        boolean[] duplicate = new boolean[256];

        for (int i = 0; i < ques.length(); i++) {

            char cc = ques.charAt(i);
            if (!duplicate[cc]) {
                String ros = ques.substring(0, i) + ques.substring(i + 1);
                printPerms(ros, ans + cc);
                duplicate[cc] = true;
            }
        }
    }

    public static void printPerms2(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }


        char cc = ques.charAt(0);
        String ros = ques.substring(1);

        HashMap<String, Boolean> duplicacy = new HashMap<>();

        for (int i = 0; i <= ans.length(); i++) {
            String tobeAnswer = ans.substring(0, i) + cc + ans.substring(i);
            if (!duplicacy.containsKey(tobeAnswer)) {
                printPerms2(ros, tobeAnswer);
                duplicacy.put(tobeAnswer, true);
            }
        }
    }


}

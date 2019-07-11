package lecture6;

import lecture4.ArraysQuestions;

import java.util.Scanner;

/**
 * Created by piyush0 on 17/06/17.
 */
public class Assignment4 {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        int n = scrn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scrn.nextInt();
        }

        ArraysQuestions.display(arr);

//        int[] arr = {2, 0, 4, 1, 3};
//        int[] inv = inverse(arr);
//        ArraysQuestions.display(inv);


//        int[] one = {9, 9, 9};
//        int[] two = {9, 9, 9, 9};
//
//        ArraysQuestions.display(sum(one, two));

//        int[][] arr = {
//                {11, 12, 13, 14},
//                {21, 22, 23, 24},
//                {31, 32, 33, 34},
//                {41, 42, 43, 44}
//        };

//        spiralPrint(arr);


        System.out.println(Math.round(1.12132 * 1000) / 1000.0);
    }

    public static boolean mirrorInverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr[i]] != i) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkInverse(int[] one, int[] two) {

        for (int i = 0; i < one.length; i++) {
            if (two[one[i]] != i) {
                return false;
            }
        }

        return true;

    }

    public static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            inv[arr[i]] = i;
        }


        return inv;

    }

    public static int[] sum(int[] one, int[] two) {
        if (two.length > one.length) {
            int[] temp = one;
            one = two;
            two = temp;
        }

        // one is larger
        int[] sum = new int[one.length + 1];

        int carry = 0;

        for (int i = 0; i < one.length; i++) {
            int s = one[i] + carry;

            if (i < two.length) {
                s += two[i];
            }


            //next carry
            carry = s / 10;

            //insert at position
            sum[i] = s % 10;

        }

        sum[sum.length - 1] = carry;


        return sum;
    }

    public static void spiralPrint(int[][] arr) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;

        int counter = 0;

        int totalElement = arr.length * arr[0].length;

        while (counter < totalElement) {

            for (int i = minRow; counter < totalElement && i <= maxRow; i++) {
                System.out.print(arr[i][minCol] + " ");
                counter++;
            }

            minCol++;


            for (int i = minCol; counter < totalElement && i <= maxCol; i++) {
                System.out.print(arr[maxRow][i] + " ");
                counter++;
            }

            maxRow--;


            for (int i = maxRow; counter < totalElement && i >= minRow; i--) {
                System.out.print(arr[i][maxCol] + " ");
                counter++;
            }

            maxCol--;

            for (int i = maxCol; counter < totalElement && i >= minCol; i--) {
                System.out.print(arr[minRow][i] + " ");
                counter++;
            }

            minRow++;

        }

    }
}

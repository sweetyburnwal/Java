package lecture8;

import lecture4.ArraysDemo;
import lecture4.ArraysQuestions;

/**
 * Created by piyush0 on 22/06/17.
 */
public class Assignment6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr, 0, arr.length - 1);

        for (int val : arr) {
            System.out.println(val);
        }
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

    public static void inverse(int[] arr, int si) {

        if (si == arr.length) {
            return;
        }

        int val = arr[si];
        inverse(arr, si + 1);
        arr[val] = si;

    }

    public static void reverse(int[] arr, int left, int right) {

        if (left > right) {
            return;
        }

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left + 1, right - 1);

    }

    public static boolean isPalindrome(int[] arr, int left, int right) {

        if (left > right) {
            return true;
        }

        if (arr[left] != arr[right]) {
            return false;
        }

        return isPalindrome(arr, left + 1, right - 1);
    }

    public static int[] allIndices(int[] arr, int si, int value, int count) {

        if (si == arr.length) {
            int[] baseArray = new int[count];
            return baseArray;
        }


        int[] recResult = null;
        int[] myResult = null;

        if (arr[si] == value) {
            recResult = allIndices(arr, si + 1, value, count + 1);
            myResult = recResult;
            myResult[count] = si;

        } else {
            recResult = allIndices(arr, si + 1, value, count);
            myResult = recResult;
        }

        return myResult;

    }

    public static boolean isSorted(int[] arr, int si) {

        if (si == arr.length - 1) {
            return true;
        }

        if (arr[si] > arr[si + 1]) {
            return false;
        }

        boolean recResult = isSorted(arr, si + 1);
        if (recResult == true) {
            return true;
        } else {
            return false;
        }

    }

    public static int triangle(int n) {

        if (n == 1) {
            return 1;
        }

        int tnm1 = triangle(n - 1);
        return tnm1 + n;
    }

    public static void invertedPattern(int n, int row, int col) {
        if (row == n) {
            return;
        }

        if (col > row) {

            invertedPattern(n, row + 1, 0);
            System.out.println();
            return;
        }


        invertedPattern(n, row, col + 1);
        System.out.print("*");

    }

    public static void pattern(int n, int row, int col) {

        if (row == n) {
            return;
        }

        if (col > row) {
            System.out.println();
            pattern(n, row + 1, 0);
            return;
        }

        System.out.print("*");
        pattern(n, row, col + 1);
    }


    public static void pascal(int n, int row, int col, int num) {

        if (row == n) {
            return;
        }

        if (col > row) {
            System.out.println();
            pascal(n, row + 1, 0, 1);
            return;
        }

        System.out.print(num + " ");
        num = num * (row - col);
        num = num / (col + 1);
        pascal(n, row, col + 1, num);

    }

}

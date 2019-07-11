package lecture4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyush0 on 13/06/17.
 */
public class ArraysQuestions {
    public static void main(String[] args) {
        int[] arr = {33, 11, 44, 0, 22};
        insertionSort(arr);
        // 0, 11, 22, 33, 44
        System.out.println(binarySearch(arr, 34));


    }

    public static int binarySearch(int[] arr, int value) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }

    public static int[] takeInput() {
        int[] arr;
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = scrn.nextInt();
        arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the " + (i + 1) + "th value");
            arr[i] = scrn.nextInt();
        }
        return arr;
    }


    public static void display(int[] arr) {

//        for (int val : arr) {
//            System.out.print(val + ", ");
//        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("END");
    }

    public static int max(int[] arr) {

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;

    }

    public static int linearSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }

        }

        return -1;

    }

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            ArraysDemo.swap(arr, left, right);

            left++;
            right--;
        }
    }

    public static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];

        // Logic for inverse


        return inv;
    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArraysDemo.swap(arr, j, j + 1);
                }
            }
        }

    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ArraysDemo.swap(arr, i, j);
                }
            }
        }

    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                ArraysDemo.swap(arr, j, j - 1);
            }

        }

    }
}

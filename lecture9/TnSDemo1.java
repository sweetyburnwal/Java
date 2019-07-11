package lecture9;

import lecture4.ArraysDemo;
import lecture4.ArraysQuestions;

import java.util.Arrays;

/**
 * Created by piyush0 on 24/06/17.
 */
public class TnSDemo1 {

    public static long startTime;

    public static void begin() {
        startTime = System.currentTimeMillis(); // epoch time
    }

    public static void finish(String algo) {
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(algo + " took " + timeTaken + " ms");
    }

    public static void main(String[] args) {
//        int[] one = {1, 3, 5, 7, 9};
//        int[] two = {2, 4};
//        int[] merged = merge(one, two);

//        ArraysQuestions.display(merged);

//        int[] arr = {4, 2, 7, 21, 812, -234, 345, -432};
//        quickSort(arr, 0, arr.length - 1);
//        ArraysQuestions.display(arr);

        int N = 10000;
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = N - i;
        }

//        begin();
//        quickSort(arr, 0, arr.length - 1);
//        finish("Quick Sort");
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = N - i;
//        }
//
//        begin();
//        bubbleSort(arr);
//        finish("Bubble Sort");

        begin();
        power(2, N);
        finish("Power");

        begin();

        finish("Power btr");

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

    public static int[] merge(int[] one, int[] two) {
        int[] retVal = new int[one.length + two.length];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                retVal[k] = one[i];
                i++;
                k++;
            } else {
                retVal[k] = two[j];
                j++;
                k++;
            }
        }

        while (i < one.length) {
            retVal[k] = one[i];
            i++;
            k++;
        }

        while (j < two.length) {
            retVal[k] = two[j];
            j++;
            k++;
        }

        return retVal;

    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] baseArray = new int[1];
            baseArray[0] = arr[hi];
            return baseArray;
        }

        int mid = (lo + hi) / 2;

        int[] firstHalf = mergeSort(arr, lo, mid);
        int[] secondHalf = mergeSort(arr, mid + 1, hi);

        return merge(firstHalf, secondHalf);

    }

    public static void quickSort(int[] arr, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;

        int pivot = arr[mid];

        int left = lo, right = hi;

        while (left <= right) {


            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            //
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }


        quickSort(arr, lo, right);
        quickSort(arr, left, hi);

    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }


        int xpnm1 = power(x, n - 1);
        int xpn = x * xpnm1;
        return xpn;

    }

    public static int getPolyVal(int x, int n) {
        int retVal = 0;
        // nlog(n)
//        for (int i = 1; i <= n; i++) {
//            retVal = (int) (retVal + i * Math.pow(x, n - i + 1));
//        }


//        int xpn = (int) Math.pow(x, n);
//
//        for (int i = 1; i <= n; i++) {
//            retVal += i * xpn;
//            xpn /= x;
//        }


        return retVal;
    }
}
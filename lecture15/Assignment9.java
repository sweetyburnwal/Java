package lecture15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by piyush0 on 06/07/17.
 */
public class Assignment9 {
    public static void main(String[] args) {

        int[] arr = {6, 2, 17, -1, 3, 5};

        printPairs(arr, 5);
    }

    public static boolean hasDuplicate(int[] arr) {

        Arrays.sort(arr); // nlogn

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }

        return false;

    }

    public static char highestFreq(String str) {

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            freq[ch]++;

        }

        char rv = '\0';
        int maxFreq = 0;


        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                rv = (char) i;
            }
        }

        return rv;

    }

    public static void printPairs(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            if (arr[left] + arr[right] == target) {
                System.out.println(arr[left] + ", " + arr[right]);

                left++;
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }


        }

    }

    public static ArrayList<Integer> intersection(int[] one, int[] two) {
        if (one.length < two.length) {
            int[] temp = one;
            one = two;
            two = temp;
        }

        ArrayList<Integer> retVal = new ArrayList<>();
        Arrays.sort(two);

        for (int i = 0; i < one.length; i++) {
            int searchResult = binarySearch(one[i], two);

            if (searchResult != -1) {
                retVal.add(one[i]);
            }
        }


        return retVal;

    }

    public static int binarySearch(int item, int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == item) {
                return mid;
            } else if (arr[mid] > item) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

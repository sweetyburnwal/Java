package lecture17;

import lecture4.ArraysQuestions;

/**
 * Created by piyush0 on 09/07/17.
 */
public class Assignment9 {
    public static void main(String[] args) throws Exception {
        int[] arr = {3,4,5,6,1,2};
        System.out.println(pivot(arr));

    }

    public static void sort01s(int[] arr) throws Exception {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            if (arr[left] == 0 && arr[right] == 0) {
                left++;
            } else if (arr[left] == 0 && arr[right] == 1) {
                left++;
                right--;
            } else if (arr[left] == 1 && arr[right] == 0) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;

            } else if (arr[left] == 1 && arr[right] == 1) {

                right--;

            } else {
                throw new Exception("Invalid input");
            }

        }

    }

    public static int duplicate(int[] arr) {
        int obSum = 0;
        for (int val : arr) {
            obSum += val;
        }
        int n = arr.length;
        int thSum = n * (n - 1) / 2;

        return (n - 1) - (thSum - obSum);

    }

    public static int pivot(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return i + 1;
            }
        }

        return -1;

    }


}

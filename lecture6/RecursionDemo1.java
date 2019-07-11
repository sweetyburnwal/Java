package lecture6;

import lecture4.ArraysQuestions;

/**
 * Created by piyush0 on 17/06/17.
 */
public class RecursionDemo1 {
    public static void main(String[] args) {
//        printDecreasing(5);

//        printIncreasing(5);

//        pdi(5);
//        int fact = factorial(5);
//        System.out.println(fact);

//        System.out.println(fib(10));

//        System.out.println(power(3, 4));

        int[] arr = {2, 3, 4, 3, 6, 3, 7};
        int[] ai = allIndices(arr, 3, 0, 0);
        ArraysQuestions.display(ai);
//        int[] arr = {1, 2, 3, 4};
//        System.out.println(isSorted(arr, 0));
    }

    public static void printDecreasing(int num) {

        if (num == 0) {
            return;
        }

        System.out.println(num); // 5
        printDecreasing(num - 1); // 4 3 2 1
    }

    public static void printIncreasing(int num) {

        if (num == 0) {
            return;
        }

        printIncreasing(num - 1); // 1 2 3 4
        System.out.println(num);

    }

    public static void pdi(int num) {

        if (num == 0) {
            return;
        }

        System.out.println(num);
        pdi(num - 1);
        System.out.println(num);
    }

    public static void pdiSkip(int num) {

        if (num == 0) {
            return;
        }
        if (num % 2 == 1) {
            System.out.println(num);
        }
        pdiSkip(num - 1);
        if (num % 2 == 0) {
            System.out.println(num);
        }
    }

    public static int factorial(int num) {

        if (num == 0) {
            return 1;
        }

        int fnm1 = factorial(num - 1);
        int fn = fnm1 * num;
        return fn;

    }

    public static int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fnm2 = fib(n - 2);
        int fnm1 = fib(n - 1);

        int fn = fnm1 + fnm2;
        return fn;

    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }


        int xpnm1 = power(x, n - 1);
        int xpn = x * xpnm1;
        return xpn;

    }

    public static int powerBtr(int x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            int rr = powerBtr(x, n / 2);
            return rr * rr;
        } else {
            int rr = powerBtr(x, n / 2);
            return rr * rr * x;
        }

    }


    public static int firstIndex(int[] arr, int value, int si) {

        if (si == arr.length) {
            return -1;
        }


        if (arr[si] == value) {
            return si;
        } else {
            int recResult = firstIndex(arr, value, si + 1);
            return recResult;
        }

    }

    public static boolean isSorted(int[] arr, int si) {

        if (si == arr.length - 1) {
            return true;
        }

        if (arr[si] > arr[si + 1]) {
            return false;
        } else {
            boolean recResult = isSorted(arr, si + 1);
            // arr[si] was correct
            if (recResult) {
                return true;
            } else {
                //  but rest of the array is not correct
                return false;
            }
        }

    }

    public static boolean contains(int[] arr, int value, int si) {

        if (si == arr.length) {
            return false;
        }


        if (arr[si] == value) {
            return true;
        } else {
            boolean recResult = contains(arr, value, si + 1);

            if (recResult == true) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static int lastIndex(int[] arr, int value, int si) {

        if (si == arr.length) {
            return -1;
        }


        int recResult = lastIndex(arr, value, si + 1);

        if (recResult != -1) {
            // rest of the array found the value
            return recResult;
        } else {
            if (arr[si] == value) {
                return si;
            } else {
                // rest of the array couldn't find it and I was not equal to value

                return -1;
            }
        }

    }

    public static int[] allIndices(int[] arr, int value, int si, int counter) {


        if (si == arr.length) {
            return new int[counter];
        }

        int[] recResult = null;
        int[] myResult = null;

        if (arr[si] == value) {
            recResult = allIndices(arr, value, si + 1, counter + 1);
            myResult = recResult;
            myResult[counter] = si;

        } else {
            recResult = allIndices(arr, value, si + 1, counter);
            myResult = recResult;
        }

        return myResult;

    }


}

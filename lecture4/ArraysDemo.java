package lecture4;

/**
 * Created by piyush0 on 13/06/17.
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] other = {1, 2, 3};


//        System.out.println(arr);

//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);


//        arr[0] = 10;
//        arr[1] = 30;
//        arr[2] = 20;

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }


        // forward only, 1 step at a time, read only
//        for (int val : arr) {
//            System.out.println(val);
//        }

//        int[] another = {100, 200, 300};
//        swap(arr, another);

    }

    // swap 1 does not work
    public static void swap(int one, int two) {
        System.out.println(one + ", " + two);

        int temp = one;
        one = two;
        two = temp;


        System.out.println(one + ", " + two);

    }

    //swap 2, works!!
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void swap(int[] arr, int[] other) {
        int[] temp = arr;
        arr = other;
        other = temp;

    }
}

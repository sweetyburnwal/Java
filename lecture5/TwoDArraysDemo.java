package lecture5;

/**
 * Created by piyush0 on 15/06/17.
 */
public class TwoDArraysDemo {

    public static void main(String[] args) {
        int[][] arr;

        arr = new int[4][3];

//        System.out.println("***************************");
//        System.out.println(arr);
//        System.out.println(arr[0]);
////        System.out.println(arr[4]);
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
//        System.out.println(arr[0][0]);
//        System.out.println(arr[0][3]);


        arr = new int[4][];

        System.out.println(arr[2]);

        arr[0] = new int[2];
        arr[1] = new int[3];
        arr[2] = new int[1];
        arr[3] = new int[5];


//        arr = new int[][3];
    }
}

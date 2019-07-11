package lecture5;

import java.util.Scanner;

/**
 * Created by piyush0 on 15/06/17.
 */
public class TwoDArraysQuestion {
    public static void main(String[] args) {

        int[][] arr = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44}
        };

        wavePrintColumn(arr);
    }


    public static int[][] takeInput() {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the number of rows");
        int rows = scrn.nextInt();

        int[][] arr = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.println("Enter the number of cols in " + (i + 1) + "th row");
            int cols = scrn.nextInt();
            arr[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter the value for (" + (i + 1) + ", " + (j + 1) + ") cell");
                arr[i][j] = scrn.nextInt();
            }
        }

        return arr;
    }

    public static void display(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void wavePrintColumn(int[][] arr) {

        for (int col = 0; col < arr[0].length; col++) {
            if (col % 2 == 1) {
                for (int row = arr.length - 1; row >= 0; row--) {
                    System.out.print(arr[row][col] + ", ");
                }
            } else {
                for (int row = 0; row < arr.length; row++) {
                    System.out.print(arr[row][col] + ", ");
                }
            }
        }

    }


    public static void wavePrint(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }


        }

    }

    public static void spiralPrint(int[][] arr) {
        //
    }
}

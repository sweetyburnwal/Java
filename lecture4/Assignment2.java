package lecture4;

import java.util.Scanner;

/**
 * Created by piyush0 on 13/06/17.
 */
public class Assignment2 {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the total number of rows");
        int rows = scrn.nextInt();
        pattern15(rows);
    }

    public static void pattern15(int rows) {

        int row = 1;

        int numSpaces = 2 * rows - 3;

        while (row <= rows) {

            //increasing numbers
            int num = 1;
            while (num <= row) {
                System.out.print(num);
                num++;
            }

            //spaces
            int spaces = 1;
            while (spaces <= numSpaces) {
                System.out.print(" ");
                spaces++;
            }


            //decreasing numbers
            num = row;
            if (row == rows) {
                num--;
            }

            while (num >= 1) {
                System.out.print(num);
                num--;
            }

            numSpaces -= 2;


            System.out.println();
            row++;
        }

    }

    public static void patter14(int rows) {
        int numSpaces = (rows) / 2;
        int startElement = 1;

        int row = 1;

        while (row <= rows) {
            //spaces
            int spaces = 1;
            while (spaces <= numSpaces) {
                System.out.print(" ");
                spaces++;
            }


            //increasing numbers
            int middleElement = 2 * startElement - 1;
            int num = startElement;

            while (num <= middleElement) {
                System.out.print(num);
                num++;
            }


            //decreasing numbers
            num = middleElement - 1;
            while (num >= startElement) {
                System.out.print(num);
                num--;
            }

            if (row > (rows / 2)) {
                // lower half
                numSpaces++;
                startElement--;
            } else {
                // upper half
                numSpaces--;
                startElement++;
            }

            System.out.println();
            row++;
        }


    }

    public static void evenOddSum(int n) {
        int counter = 1;
        int oddSum = 0;
        int evenSum = 0;

        while (n != 0) {

            int rem = n % 10;

            if (counter % 2 == 0) {
                //even position
                evenSum += rem;

            } else {
                // odd position
                oddSum += rem;
            }


            counter++;
            n = n / 10;

        }


        System.out.println("Even sum is " + evenSum);
        System.out.println("Odd sum is " + oddSum);

    }

    public static void pattern8(int rows) {

        int row = 1;

        while (row <= rows) {

            // print row no
            System.out.print(row);

            // zeros
            int totalZeros = row - 2;
            int col = 1;
            while (col <= totalZeros) {
                System.out.print(0);
                col++;
            }


            // print row no 2nd time
            if (row != 1) {
                System.out.print(row);
            }
            System.out.println();
            row++;
        }


    }

    public static void pascalTriangle(int rows) {

        int row = 0;

        while (row < rows) {

            int col = 0;
            int num = 1;

            while (col <= row) {
                System.out.print(num + " ");
                num = num * (row - col);
                num = num / (col + 1);

                col++;
            }

            System.out.println();

            row++;
        }

    }
}

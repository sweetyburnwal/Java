package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 10/06/17.
 */
public class SumToN {
    public static void main(String[] args) {

        Scanner scrn = new Scanner(System.in);
        System.out.println("Please enter the value of n");

        int n = scrn.nextInt();

        int sum = 0;
        int counter = 1;


        while (counter <= n) {

            sum = sum + counter;

            counter = counter + 1;
        }

        System.out.println("Sum from 1 to " + n + " is " + sum);

    }
}

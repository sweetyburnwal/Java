package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 10/06/17.
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the value of n");
        int n = scrn.nextInt();

        int fNo = 0;
        int sNo = 1;

        int counter = 1;

        while (counter <= n) {

            int sum = fNo + sNo;


            fNo = sNo;
            sNo = sum;
            counter++;

        }

        System.out.println(" The answer is " + fNo);
    }
}

package lecture3;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class Log {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the value of x");
        int x = scrn.nextInt();

        System.out.println("Enter the value of n");
        int n = scrn.nextInt();

        int product = 1;
        int count = 0;

        while (product != x) {

            product = product * n;
            count++;
        }

        System.out.println("Log " + x + " base " + n + " is " + count);
    }
}

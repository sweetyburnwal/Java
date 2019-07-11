package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 10/06/17.
 */
public class CheckPrime {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Please enter a number ");
        int n = scrn.nextInt();

        int counter = 2;

        while (counter * counter <= n) {
            if (n % counter == 0) {
                System.out.println("Not Prime");
                return;
            }

            counter = counter + 1;
        }

        System.out.println("Prime");
    }
}

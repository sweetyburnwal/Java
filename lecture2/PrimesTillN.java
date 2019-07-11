package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 10/06/17.
 */
public class PrimesTillN {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the value of n");
        int n = scrn.nextInt();

        for (int num = 2; num <= n; num++) {

            int counter = 2;
            boolean isPrime = true;

            while (counter * counter <= num) {

                if (num % counter == 0) {
                    isPrime = false;
                    break;
                }

                counter++;
            }

            if (isPrime == true) {
                System.out.println(num);
            }

        }


    }
}

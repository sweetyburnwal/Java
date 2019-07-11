package lecture3;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class CountFives {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the number to count fives");
        int n = scrn.nextInt();
        int counter = 0;
        while (n != 0) {
            int rem = n % 10;

            if (rem == 5) {
                counter++;
            }

            n = n / 10;

        }

        System.out.println("Number of fives are " + counter);
    }
}

package lecture3;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class Asgn1_Q10 {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the first number");
        int dividend = scrn.nextInt();
        System.out.println("Enter the second number");
        int divisor = scrn.nextInt();

        while (divisor != 0) {
            int temp = divisor;
            int rem = dividend % divisor;

            divisor = rem;
//            dividend = divisor; because divisor has been updated
            dividend = temp;
        }

        System.out.println("GCD is " + dividend);

    }
}

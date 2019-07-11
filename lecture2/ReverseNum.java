package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class ReverseNum {

    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the number to find the reverse");
        int num = scrn.nextInt();

        int rev = 0;

        while (num != 0) {
            int rem = num % 10;

            rev = rev * 10 + rem;
            num = num / 10;

        }

        System.out.println(rev);

    }
}

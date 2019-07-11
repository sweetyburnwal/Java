package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 10/06/17.
 */
public class Asgn1_Q6 {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the total number of rows ");
        int n = scrn.nextInt();

        int row = 1;
        int numSpaces = (n / 2);
        int numStars = 1;


        while (row <= n) {

            int spaces = 1;
            while (spaces <= numSpaces) {
                System.out.print(" ");
                spaces++;
            }

            int stars = 1;
            while (stars <= numStars) {
                System.out.print("*");
                stars++;
            }

            if (row > (n / 2)) {
                numSpaces++;
                numStars = numStars - 2;
            } else {
                numSpaces--;
                numStars = numStars + 2;
            }


            System.out.println();
            row++;
        }


    }
}

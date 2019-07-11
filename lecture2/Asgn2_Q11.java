package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 17/06/17.
 */
public class Asgn2_Q11 {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = scrn.nextInt();

        int row = 1;

        int numSpaces = (rows / 2);
        int numStars = 1;


        while (row <= rows) {

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

            // upper half

            if (row <= (rows / 2)) {
                numSpaces--;
                numStars += 2;
            } else {
                numSpaces++;
                numStars -= 2;
            }

            System.out.println();
            row++;
        }
    }
}

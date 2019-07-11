package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 17/06/17.
 */
public class HollowDiamond {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();

        int row = 1, col = 1, numSpaces = 1, numStars = (N + 1) / 2;
        while (row <= N) {
            col = 1;
            while (col <= numStars) {
                System.out.print("*\t");
                col++;
            }

            col = 1;
            while (col <= numSpaces) {
                System.out.print("\t");
                col++;
            }

            col = 1;
            while (col <= numStars) {
                System.out.print("*\t");
                col++;
            }

            if (row <= N / 2) {
                numSpaces += 2;
                numStars--;
            } else {
                numSpaces -= 2;
                numStars++;
            }

            System.out.println();
            row++;
        }
    }
}

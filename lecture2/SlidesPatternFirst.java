package lecture2;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class SlidesPatternFirst {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        int n = scrn.nextInt();

        int numSpaces = n - 1;

        int row = 1;

        while (row <= n) {

            //Spaces
            int spaces = 1;

            while (spaces <= numSpaces) {
                System.out.print(" ");
                spaces++;
            }

            //Increasing nums

            int num = row;
            while (num <= 2 * row - 1) {
                System.out.print(num);
                num++;
            }


            //Decreasing nums

            num = 2 * row - 2;

            while (num >= row) {
                System.out.print(num);
                num--;
            }


            System.out.println();
            row++;
            numSpaces--;
        }
    }
}

package lecture2;

/**
 * Created by piyush0 on 10/06/17.
 */
public class Asgn1_Q6b {
    public static void main(String[] args) {
        int n = 5;

        int row = 1;
        int numSpaces = (n / 2);
        int numStars = 1;

        while (row <= n) {

            //Spaces
            int spaces = 1;
            while (spaces <= numSpaces) {
                System.out.print(" ");
                spaces++;
            }


            //Stars
            int stars = 1;
            while (stars <= numStars) {
                System.out.print("*");
                stars++;
            }

            System.out.println();

            if (row > (n / 2)) {
                numSpaces = numSpaces + 1;
                numStars = numStars - 2;
            } else {
                numSpaces = numSpaces - 1;
                numStars = numStars + 2;
            }
            row++;
        }
    }
}

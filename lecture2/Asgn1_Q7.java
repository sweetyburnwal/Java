package lecture2;

/**
 * Created by piyush0 on 10/06/17.
 */
public class Asgn1_Q7 {
    public static void main(String[] args) {
        int n = 5;

        int numSpaces = 1;
        int numStars = (n / 2) + 1;

        int row = 1;


        while (row <= n) {

            //Stars
            int stars = 1;
            while (stars <= numStars) {
                System.out.print("*");
                stars++;
            }


            //Spaces
            int spaces = 1;
            while (spaces <= numSpaces) {
                System.out.print(" ");
                spaces++;
            }


            //Stars
            stars = 1;
            while (stars <= numStars) {
                System.out.print("*");
                stars++;
            }


            if (row > (n / 2)) {
                //Lower half
                numStars = numStars + 1;
                numSpaces = numSpaces - 2;
            } else {
                //Upper half
                numStars = numStars - 1;
                numSpaces = numSpaces + 2;
            }

            System.out.println();
            row++;
        }
    }

}

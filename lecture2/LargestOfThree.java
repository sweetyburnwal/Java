package lecture2;

/**
 * Created by piyush0 on 10/06/17.
 */
public class LargestOfThree {
    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        int c = 8;

        if (a >= b && a >= c) {
            System.out.println(a);
        } else {
            if (b >= c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }

    }
}

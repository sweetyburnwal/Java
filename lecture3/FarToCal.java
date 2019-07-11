package lecture3;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class FarToCal {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the start value");
        int startF = scrn.nextInt();

        System.out.println("Enter the end value");
        int endF = scrn.nextInt();

        System.out.println("Enter the step value");
        int step = scrn.nextInt();

        for (int currentF = startF; currentF <= endF; currentF += step) {
            System.out.print(currentF + " ");

//            int cel = (int) ((5.0 / 9) * (currentF - 32));

            int cel = 5 * (currentF - 32);
            cel = cel / 9;

            System.out.println(cel);
        }

    }
}

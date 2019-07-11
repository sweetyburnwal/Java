package lecture3;

import java.util.Scanner;

/**
 * Created by piyush0 on 11/06/17.
 */
public class Asgn1_Q8 {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter the value of n");
        int n = scrn.nextInt();

        int fNo = 0;
        int sNo = 1;

        while (fNo <= n) {
            System.out.println(fNo);
            int sum = fNo + sNo;
            fNo = sNo;
            sNo = sum;
        }

    }
}

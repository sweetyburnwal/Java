package lecture4;

import java.util.Scanner;

/**
 * Created by piyush0 on 13/06/17.
 */
public class CharacterInput {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        System.out.println("Enter a character");

        char ch = scrn.next().charAt(0);

        System.out.println("The character you entered is " + ch);

    }

}

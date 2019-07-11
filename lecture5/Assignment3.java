package lecture5;

import java.util.Scanner;

/**
 * Created by piyush0 on 15/06/17.
 */
public class Assignment3 {
    public static void main(String[] args) {
        // floating point number precision
//        System.out.println(0.1 + 0.2);

//        System.out.println(isValidSeries());

//            simpleCalculator();
//        System.out.println(sqrtWPrec(18,4));
    }

    public static void simpleCalculator() {

        Scanner scrn = new Scanner(System.in);

        while (true) {

            System.out.println("Enter operand 1");
            int op1 = scrn.nextInt();

            System.out.println("Enter operand 2");
            int op2 = scrn.nextInt();

            System.out.println("Enter operation");
            char oprn = scrn.next().charAt(0);


            if (oprn == '+') {
                System.out.println(op1 + op2);
            } else if (oprn == '-') {
                System.out.println(op1 - op2);
            } else if (oprn == '*') {
                System.out.println(op1 * op2);
            } else if (oprn == '/') {
                System.out.println(op1 / op2);
            } else if (oprn == '%') {
                System.out.println(op1 % op2);
            } else if (oprn == 'x' || oprn == 'X') {
                System.out.println(op1 - op2);
                break;
            }
        }

    }

    public static boolean isValidSeries() {
        Scanner scrn = new Scanner(System.in);
        System.out.println("Enter the total numbers in the sequence");
        int n = scrn.nextInt();
        System.out.println("Enter the numbers");
        int prev = scrn.nextInt();

        boolean decreasingPart = true;

        for (int i = 1; i < n; i++) {
            int current = scrn.nextInt();

            if (decreasingPart) {

                if (current > prev) {
                    decreasingPart = false;
                }

            } else {

                if (current < prev) {
                    return false;
                }
            }

            prev = current;

        }

        return true;

    }

    public static int inverse(int num) {
        int inv = 0;
        int counter = 1;

        while (num != 0) {
            int rem = num % 10;
            // Math.pow(x,n) => x^n
            inv = inv + counter * (int) Math.pow(10, rem - 1);
            num = num / 10;
            counter++;
        }


        return inv;
    }

    public static boolean isMirrorInverse(int num) {
        int inv = inverse(num);

        if (inv == num) {
            return true;
        } else {
            return false;
        }

//        return inv == num;

//        return num == inverse(num);

    }

    public static boolean isArmstrong(int num) {

        int cubeSum = 0;
        int temp = num;

        while (num != 0) {
            int rem = num % 10;

            cubeSum += rem * rem * rem;

            num = num / 10;
        }

        return cubeSum == temp;
    }

    public static void sequence(int n1, int n2) {

//        int counter = 0;
//        for (int i = 0; i < n1; i++) {
//            int num = 3 * counter + 2;
//            if (num % n2 != 0) {
//                System.out.println(num);
//            }
//            counter++;
//        }


        int counter = 0;
        int i = 0;

        while (true) {
            int num = 3 * i + 2;

            if (counter > n1) {
                break;
            }

            if (num % n2 != 0) {
                System.out.print(num + ", ");
                counter++;
            }


            i++;

        }
    }

    public static int simpleSqrt(int num) {

        int counter = 0;
        while (counter * counter <= num) {
            counter++;
        }

        return counter - 1;

    }

    public static double sqrtWPrec(int num, int prec) {

        double incrementor = 1;
        double ans = 0;

        for (int i = 0; i < prec; i++) {

            while (ans * ans <= num) {
                ans += incrementor;
            }

            ans = ans - incrementor;
            incrementor = incrementor / 10;

        }


        return ans;

    }

    public static int countFives(int num) {

        int counter = 0;

        while (num != 0) {
            int rem = num % 10;
            if (rem == 5) {
                counter++;
            }

            num = num / 10;
        }
        return counter;
    }

    public static int countDigit(int num, int digit) {

        int counter = 0;

        while (num != 0) {
            int rem = num % 10;
            if (rem == digit) {
                counter++;
            }

            num = num / 10;
        }
        return counter;
    }


}

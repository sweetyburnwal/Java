package lecture4;

/**
 * Created by piyush0 on 13/06/17.
 */
public class Assignment3 {
    public static void main(String[] args) {
        int binary = any2any(8, 2, 57);
        System.out.println(binary);

    }

    public static int any2any(int srcBase, int destBase, int num) {
        int decimal = any2dec(srcBase, num);
        return dec2any(destBase, decimal);

    }

    public static int bin2dec(int bin) {

        int dec = 0;

        int twoPower = 1;
        while (bin != 0) {
            int rem = bin % 10;
            int component = rem * twoPower;
            dec += component;
            twoPower = twoPower * 2;
            bin = bin / 10;

        }
        return dec;
    }

    public static int dec2bin(int dec) {

        int bin = 0;

        int tenPower = 1;
        while (dec != 0) {
            int rem = dec % 2;
            int component = rem * tenPower;
            dec += component;
            tenPower = tenPower * 10;
            dec = dec / 2;

        }
        return bin;
    }
    public static int dec2any(int destBase, int dec) {
        int num = 0;
        int tenPower = 1;

        while (dec != 0) {
            int rem = dec % destBase;
            int component = rem * tenPower;
            num += component;
            tenPower *= 10;
            dec = dec / destBase;
        }


        return num;
    }

    public static int any2dec(int srcBase, int num) {
        int dec = 0;

        int basePower = 1;
        while (num != 0) {
            int rem = num % 10;
            int component = rem * basePower;
            dec += component;
            basePower *= srcBase;
            num = num / 10;

        }

        return dec;
    }


}

package lecture10;

/**
 * Created by piyush0 on 25/06/17.
 */
public class TnSDemo2 {

    public static long startTime;

    public static void begin() {
        startTime = System.currentTimeMillis(); // epoch time
    }

    public static void finish(String algo) {
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(algo + " took " + timeTaken + " ms");
    }

    public static void main(String[] args) {
//        int n = 100000;
//
//        begin();
//        getConcatenatedValuesBtr(n);
//        finish("getConcatenatedValuesBtr");
//
//        begin();
//        getConcatenatedValues(n);
//        finish("getConcatenatedValues");

//        pbp(0, 5, "");

        int n = 2;
        pmp(0, 0, n, n, "");

    }

    public static void SOE(int N) {

        boolean[] primes = new boolean[N + 1];

        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        int sqrt = (int) Math.sqrt(N);
        int num = 2;
        while (num <= sqrt) {

            int multiplier = num;






            if (primes[num]) {
                while (multiplier * num <= N) {
                    primes[num * multiplier] = false;
                    multiplier++;
                }
            }
            num++;
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }


    }

    public static int countPalindromicSubstrings(String str) {

        int count = 0;

        //odd length

        for (int axis = 0; axis < str.length(); axis++) {
            int orbit = 0;

            while (axis - orbit >= 0 &&
                    axis + orbit < str.length() &&
                    str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
                count++;
                orbit++;
            }

        }


        //even length
        for (int axis = 1; axis < str.length(); axis++) {

            int orbit = 1;

            while (axis - orbit >= 0 &&
                    axis + orbit - 1 < str.length()
                    && str.charAt(axis - orbit) == str.charAt(axis + orbit - 1)) {
                count++;
                orbit++;
            }

        }


        return count;


    }

    public static String getConcatenatedValuesBtr(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        return sb.toString();

    }

    public static String getConcatenatedValues(int n) {
        String retVal = "";

        for (int i = 1; i <= n; i++) {
            retVal += i;
        }

        return retVal;

    }

    public static void pbp(int current, int end, String ans) {

        if (current > end) {
            return;
        }

        if (current == end) {
            System.out.println(ans);
            return;
        }


        for (int i = 1; i <= 6; i++) {
            pbp(current + i, end, ans + i);
        }


    }

    public static int cbp(int current, int end) {

        if (current > end) {
            return 0;
        }

        if (current == end) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= 6; i++) {
            count += cbp(current + i, end);
        }


        return count;

    }

    public static void pmp(int cr, int cc, int er, int ec, String ans) {

        if (cc > ec || cr > er) {
            return;
        }

        if (cc == ec && cr == er) {
            System.out.println(ans);
            return;
        }

        pmp(cr + 1, cc, er, ec, ans + "v");
        pmp(cr, cc + 1, er, ec, ans + "h");

    }

}

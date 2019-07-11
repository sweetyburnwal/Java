package lecture22;

import lecture13.P;

/**
 * Created by piyush0 on 20/07/17.
 */
public class Client {

    public static long startTime;

    public static void begin() {
        startTime = System.currentTimeMillis(); // epoch time
    }

    public static void finish(String algo) {
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(algo + " took " + timeTaken + " ms");
    }

    public static void main(String[] args) {

        int n = 70;

//        begin();
//        System.out.println(fibI(n));
//        finish("Iterative");
//
//        begin();
//        System.out.println(fibRS(n, new int[n + 1]));
//        finish("Fib DP");
//
//        begin();
//        System.out.println(fib(n));
//        finish("Fib normal");

//        n = 30;
//
//        begin();
//        System.out.println(cbpI(0, n));
//        finish("Iterative");
//
//        begin();
//        System.out.println(cbpRS(0, n, new int[n + 1]));
//        finish("DP");
//
//        begin();
//        System.out.println(cbp(0, n));
//        finish("Normal");

//        n = 20;
//
//        begin();
//        System.out.println(cmpI(0, 0, n, n));
//        finish("Iterative");
//
//        begin();
//        System.out.println(cmpRS(0, 0, n, n, new int[n + 1][n + 1]));
//        finish("DP");
//
//        begin();
//        System.out.println(cmp(0, 0, n, n));
//        finish("Normal");

//        String s1 = "abcdfadjskjkdfsajksdfaef";
//        String s2 = "zadfsahiudfsaihdke";
//
//        begin();
//        System.out.println(lcsI(s1, s2));
//        finish("Iterative");
//
//        begin();
//        System.out.println(lcsRS(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
//        finish("DP");
//
//        begin();
//        System.out.println(lcs(s1, s2));
//        finish("Normal");

        String s1 = "fdaskjlnsdkdfsafdlsjadsfjak";
        String s2 = "dvsklnankldflnkadfnlkfad";

        begin();
        System.out.println(editDistanceI(s1,s2));
        finish("Iterative");

        begin();
        System.out.println(editDistanceRS(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
        finish("DP");

        begin();
        System.out.println(editDistance(s1, s2));
        finish("Normal");
    }

    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);

        int fn = fnm1 + fnm2;
        return fn;

    }

    public static int fibRS(int n, int[] storage) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (storage[n] != 0) {
            return storage[n];
        }


        int fnm1 = fibRS(n - 1, storage);
        int fnm2 = fibRS(n - 2, storage);

        int fn = fnm1 + fnm2;
        storage[n] = fn;
        return fn;

    }

    public static int fibI(int n) {
        int fNo = 0;
        int sNo = 1;

        int counter = 1;

        while (counter <= n) {

            int sum = fNo + sNo;
            fNo = sNo;
            sNo = sum;
            counter++;
        }

        return fNo;
    }

    public static int cbp(int start, int end) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        int count = 0;


        for (int i = 1; i <= 6; i++) {
            count += cbp(start + i, end);
        }

        return count;

    }

    public static int cbpRS(int start, int end, int[] storage) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (storage[start] != 0) {
            return storage[start];
        }

        int count = 0;


        for (int i = 1; i <= 6; i++) {
            count += cbpRS(start + i, end, storage);
        }

        storage[start] = count;

        return count;


    }

    public static int cbpI(int start, int end) {
        int[] storage = new int[end + 1];

        storage[end] = 1;

        for (int i = end - 1; i >= 0; i--) {

            for (int j = 1; i + j < storage.length &&
                    j <= 6; j++) {
                storage[i] += storage[i + j];
            }

        }

        return storage[start];

    }

    public static int cmp(int cc, int cr, int ec, int er) {

        if (cc > ec || cr > er) {
            return 0;
        }

        if (cc == ec && cr == er) {
            return 1;
        }

        int count = 0;

        count += cmp(cc + 1, cr, ec, er);
        count += cmp(cc, cr + 1, ec, er);

        return count;


    }

    public static int cmpRS(int cc, int cr, int ec, int er, int[][] storage) {

        if (cc > ec || cr > er) {
            return 0;
        }

        if (cc == ec && cr == er) {
            return 1;
        }

        if (storage[cc][cr] != 0) {
            return storage[cc][cr];
        }

        int count = 0;

        count += cmpRS(cc + 1, cr, ec, er, storage);
        count += cmpRS(cc, cr + 1, ec, er, storage);

        storage[cc][cr] = count;

        return count;


    }

    public static int cmpI(int cc, int cr, int ec, int er) {
        // init
        int[][] storage = new int[ec + 1][er + 1];

        // seeding
        storage[ec][er] = 1;

        // loop

        for (int i = ec; i >= 0; i--) {
            for (int j = er; j >= 0; j--) {

                if (i + 1 < storage.length) {
                    storage[i][j] += storage[i + 1][j];
                }
                if (j + 1 < storage[i].length) {
                    storage[i][j] += storage[i][j + 1];
                }
            }
        }

        //return

        return storage[cc][cr];
    }

    public static int lcs(String s1, String s2) {

        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }


        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            return 1 + lcs(ros1, ros2);
        } else {
            int recResult1 = lcs(ros1, s2);
            int recResult2 = lcs(s1, ros2);

            return Math.max(recResult1, recResult2);
        }
    }

    public static int lcsRS(String s1, String s2, int[][] storage) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        if (storage[s1.length()][s2.length()] != 0) {
            return storage[s1.length()][s2.length()];
        }


        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            int x = lcsRS(ros1, ros2, storage);
            storage[s1.length()][s2.length()] = 1 + x;
            return 1 + x;
        } else {
            int recResult1 = lcsRS(ros1, s2, storage);
            int recResult2 = lcsRS(s1, ros2, storage);

            storage[s1.length()][s2.length()] = Math.max(recResult1, recResult2);
            return Math.max(recResult1, recResult2);
        }


    }

    public static int lcsI(String s1, String s2) {
        int[][] storage = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {

                if (i == s1.length() || j == s2.length()) {
                    storage[i][j] = 0;
                } else {

                    if (s1.charAt(i) == s2.charAt(j)) {
                        storage[i][j] = storage[i + 1][j + 1] + 1;
                    } else {
                        int f1 = storage[i + 1][j];
                        int f2 = storage[i][j + 1];

                        storage[i][j] = Math.max(f1, f2);
                    }

                }
            }
        }

        return storage[0][0];
    }

    public static int editDistance(String s1, String s2) {


        if (s1.length() == 0) {

            return s2.length();
        }

        if (s2.length() == 0) {

            return s1.length();
        }

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            return editDistance(ros1, ros2);
        } else {

            int f1 = editDistance(ros1, ros2);
            int f2 = editDistance(ros1, s2);
            int f3 = editDistance(s1, ros2);

            return Math.min(f1, Math.min(f2, f3)) + 1;

        }

    }

    public static int editDistanceRS(String s1, String s2, int[][] storage) {
        if (s1.length() == 0) {

            return s2.length();
        }

        if (s2.length() == 0) {

            return s1.length();
        }

        if (storage[s1.length()][s2.length()] != 0) {
            return storage[s1.length()][s2.length()];
        }

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            int ans = editDistanceRS(ros1, ros2, storage);
            storage[s1.length()][s2.length()] = ans;
            return ans;
        } else {

            int f1 = editDistanceRS(ros1, ros2, storage);
            int f2 = editDistanceRS(ros1, s2, storage);
            int f3 = editDistanceRS(s1, ros2, storage);

            int ans = Math.min(f1, Math.min(f2, f3)) + 1;

            storage[s1.length()][s2.length()] = ans;
            return ans;

        }

    }

    public static int editDistanceI(String s1, String s2) {
        int[][] storage = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {


                if (i == s1.length()) {
                    storage[i][j] = s2.length() - j;
                    continue;
                }

                if (j == s2.length()) {
                    storage[i][j] = s1.length() - i;
                    continue;
                }


                if (s1.charAt(i) == s2.charAt(j)) {
                    storage[i][j] = storage[i + 1][j + 1];
                } else {
                    int f1 = storage[i + 1][j];
                    int f2 = storage[i][j + 1];
                    int f3 = storage[i + 1][j + 1];

                    storage[i][j] = Math.min(f1, Math.min(f2, f3)) + 1;
                }


            }
        }


        return storage[0][0];
    }
}
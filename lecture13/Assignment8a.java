package lecture13;

/**
 * Created by piyush0 on 01/07/17.
 */
public class Assignment8a {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 7, 5, 0};
//        System.out.println(countSplit(arr, 0, 0, 0));

//        printLexicoGreater("bacd", "", "bacd");

        printLexicoGreaterBnB("bacd", "", false);
    }


    public static void printTOH(String src,
                                String aux,
                                String dest,
                                int n) {
        if (n == 0) {
            return;
        }

        printTOH(src, dest, aux, n - 1);
        System.out.println("Move " + n + "th disk from " +
                "" + src + " to " + dest);
        printTOH(aux, src, dest, n - 1);
    }



    public static int countSplit(int[] arr, int si, int one, int two) {

        if (si == arr.length) {
            if (one == two) {
                return 1;
            } else {
                return 0;
            }

        }


        int count = 0;

        count += countSplit(arr, si + 1, one + arr[si], two);
        count += countSplit(arr, si + 1, one, two + arr[si]);

        return count;

    }

//    public static int countTargetSum(int[] arr, int si, int target) {
//        return 0;
//    }

    public static void printLexicoGreater(String str, String ans, String org) {

        if (str.length() == 0) {

            if (ans.compareTo(org) > 0) {
                System.out.println(ans);
            }

            return;
        }


        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);

            printLexicoGreater(ros, ans + cc, org);
        }

    }

    public static void printLexicoGreaterBnB(String str, String ans, boolean larger) {


        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char cc = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);

            if (larger) {
                printLexicoGreaterBnB(ros, ans + cc, true);
            } else {
                if (cc > str.charAt(0)) {
                    printLexicoGreaterBnB(ros, ans + cc, true);
                } else if (cc == str.charAt(0)) {
                    printLexicoGreaterBnB(ros, ans + cc, false);
                }
            }

        }

    }

}

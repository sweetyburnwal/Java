package lecture6;

/**
 * Created by piyush0 on 17/06/17.
 */
public class StringBuilderQuestion {
    public static void main(String[] args) {
//        System.out.println(toggle("AbcCDd"));

//        System.out.println(evenOdd("bdg"));

        System.out.println(insertDiff("acf"));
    }


    public static String toggle(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                //upper case
                char ch = str.charAt(i);
                char toggledChar = (char) (ch - 'A' + 'a');
                sb.append(toggledChar);
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                //lower case
                char ch = str.charAt(i);
                char toggledChar = (char) (ch - 'a' + 'A');
                sb.append(toggledChar);
            }

        }


        return sb.toString();

    }

    public static String evenOdd(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (i % 2 == 0) {
                //even
                char ch = str.charAt(i);
                char tbp = (char) (ch - 1);
                sb.append(tbp);

            } else {
                //odd
                char ch = str.charAt(i);
                char tbp = (char) (ch + 1);
                sb.append(tbp);
            }

        }


        return sb.toString();

    }

    public static String insertDiff(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            char cc = str.charAt(i);
            char nc = str.charAt(i + 1);
            int diff = nc - cc;

            sb.append(cc);
            sb.append(diff);
        }

        sb.append(str.charAt(str.length() - 1));


        return sb.toString();
    }

}

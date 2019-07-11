package lecture8;

/**
 * Created by piyush0 on 22/06/17.
 */
public class Assignment5 {
    public static void main(String[] args) {
        System.out.println(compression("aaabbccds"));
    }

    public static String compression(String str) {

        StringBuilder sb = new StringBuilder();


        int i = 0;

        while (i < str.length()) {

            char ch = str.charAt(i);
            int counter = 0;
            sb.append(ch);
            while (i < str.length() && str.charAt(i) == ch) {
                i++;
                counter++;
            }

            if (counter != 1) {
                sb.append(counter);
            }
        }


        return sb.toString();

    }

    public static String removeDuplicates(String str) {

        StringBuilder sb = new StringBuilder();


        int i = 0;

        while (i < str.length()) {

            char ch = str.charAt(i);

            sb.append(ch);
            while (i < str.length() && str.charAt(i) == ch) {
                i++;
            }

        }


        return sb.toString();
    }
}

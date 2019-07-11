package lecture12;

/**
 * Created by piyush0 on 29/06/17.
 */
public class Assignment7 {
    public static void main(String[] args) {
//        System.out.println(obedientString("abbab", ""));

//        System.out.println(parenthesis("abc(xyz)def", false));
        String str = "[a + {b + (c + d) + e} + f]";

        System.out.println(isBalanced(str, ""));
    }

    public static boolean obedientString(String str, String prev) {
        if (prev.length() == 0) {
            return str.length() == 0
                    || str.charAt(0) == 'a' && obedientString(str.substring(1), "a");
        } else if (prev.equals("a")) {
            return str.length() == 0
                    || str.charAt(0) == 'a' && obedientString(str.substring(1), "a")
                    || str.length() > 1 && str.substring(0, 2).equals("bb") && obedientString(str.substring(2), "bb");

        } else if (prev.equals("bb")) {
            return str.length() == 0
                    || str.charAt(0) == 'a' && obedientString(str.substring(1), "a");
        } else {
            return false;
        }
    }

    public static String parenthesis(String str, boolean inside) {

        if (str.length() == 0) {
            return "";
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        if (inside) {
            if (cc == ')') {
                return "";
            } else {
                return cc + parenthesis(ros, true);
            }


        } else {
            if (cc == '(') {
                return parenthesis(ros, true);
            } else {
                return parenthesis(ros, false);
            }
        }

    }

    public static boolean isBalanced(String str, String brackets) {

        if (str.length() == 0) {
            return brackets.length() == 0;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        if (cc == '(' || cc == '[' || cc == '{') {
            return isBalanced(ros, brackets + cc);

        } else if (cc == ')' || cc == ']' || cc == '}') {
            if (brackets.length() == 0) {

                // closing brackets were extra
                return false;
            }

            char lb = brackets.charAt(brackets.length() - 1);

            if (cc == ')' && lb != '(') {
                return false;
            } else if (cc == ']' && lb != '[') {
                return false;
            } else if (cc == '}' && lb != '{') {
                return false;
            }

            return isBalanced(ros, brackets.substring(0, brackets.length() - 1));

        } else {
            return isBalanced(ros, brackets);
        }

    }
}

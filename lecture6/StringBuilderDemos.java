package lecture6;

/**
 * Created by piyush0 on 17/06/17.
 */
public class StringBuilderDemos {

    public static void main(String[] args) {

        // String

//        StringBuilder sb = new StringBuilder();
//        sb.append("abcd");
//        System.out.println(sb);
//        //lenght
//        System.out.println(sb.length());
//        //getting char
//        System.out.println(sb.charAt(2));
//
//
//        //setting chars
//        sb.setCharAt(2, 'x');
//        System.out.println(sb);
//
//        //append
//        sb.append("qwerty");
//
//        System.out.println(sb);
//
//        //delete
//        sb.deleteCharAt(0);
//        System.out.println(sb);
//
//
//        sb = new StringBuilder("abcd");
////        sb.delete(2, 4);
//
//        System.out.println(sb);
//
//
//        // insert
//
//        sb.insert(2, "lol");
//        System.out.println(sb);


        // Strings

        String str = "abcd";

        System.out.println(str.length());
        System.out.println(str.charAt(2));
        int i = 2;
        str = str.substring(0, i) + 'x' + str.substring(i + 1);
        System.out.println(str);

        str = str + "qwerty";
        System.out.println(str);

        i = 1;
        str = str.substring(0, i) + str.substring(i + 1);
        System.out.println(str);

        str = "abcd";

        i = 2;
        str = str.substring(0, i) + "lol" + str.substring(i);
        System.out.println(str);
    }
}


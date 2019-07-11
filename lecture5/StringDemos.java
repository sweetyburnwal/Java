package lecture5;

/**
 * Created by piyush0 on 15/06/17.
 */
public class StringDemos {
    public static void main(String[] args) {
//        String str;

//        str = "Hello";

//        System.out.println(str.length());
//
//
//        System.out.println(str.charAt(0));
////		System.out.println(str.charAt(str.length()));
//        System.out.println(str.charAt(str.length() - 1));


        // Part 4
//        System.out.println(str.substring(2, 4));
//
//        System.out.println(str.substring(2, 3));
//        System.out.println(str.substring(2, 2));
////   	System.out.println(str.substring(2, 1));
//        System.out.println(str.substring(2, 5));
////		System.out.println(str.substring(2, 6));
//        System.out.println(str.substring(2));
//        System.out.println(str.substring(2));
//        System.out.println("********************************");

//        String s1 = "hi";
//        String s2 = "bye";
//        String s3 = s1 + s2;
//        System.out.println(s1 + ", " + s2 + ", " + s3);
//        String s4 = s1.concat(s2);
//        System.out.println(s1 + ", " + s2 + ", " + s4);
//        System.out.println("********************************");

//        str = "Hello";

        // Part 6
//        System.out.println(str.indexOf("ell"));
//        System.out.println(str.indexOf("eL"));
//        System.out.println("********************************");

        // Part 7
//        System.out.println(str.startsWith("He"));
//        System.out.println(str.startsWith("he"));
//        System.out.println("********************************");


        // Part 8
        String s1 = "Hello";
        String s2 = s1;
        String s3 = "Hello";
        String s4 = new String("Hello");

        System.out.println((s1 == s2) + ", " + s1.equals(s2));
        System.out.println((s1 == s3) + ", " + s1.equals(s3));
        System.out.println((s1 == s4) + ", " + s1.equals(s4));
    }
}

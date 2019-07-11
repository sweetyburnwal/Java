package lecture13;

import java.util.ArrayList;

/**
 * Created by piyush0 on 01/07/17.
 */
public class Client {
//    public static void main(String[] args) {
//
//        System.out.println("~~~~~~~~~CASE 1~~~~~~~~~~");
//        P obj1 = new P();
//
//        obj1.fun();
//        obj1.fun1();
////        obj1.fun2();
//
//
//        System.out.println(obj1.d);
//        System.out.println(obj1.d1);
////        System.out.println("hi");
////        System.out.println(((C) obj1).d2);
////        System.out.println("bye");
//
//        System.out.println("~~~~~~~~~CASE 2~~~~~~~~~");
//
//        P obj2 = new C();
//
//        // compiler looks at LHS or reference
//        // JVM looks at RHS or object
//
//        System.out.println(obj2.d); // 10
//        System.out.println(obj2.d1); // 11
//        System.out.println(((C) obj2).d2); // 21
//
//        obj2.fun();
//        obj2.fun1();
////        obj2.fun2();
//
//        System.out.println("~~~~~~~~CASE 3~~~~~~~~");
//
//        // not allowed
////        C obj3 = new P();
//
//
//        System.out.println("~~~~~~~~CASE 4~~~~~~~~~");
//
//        C obj4 = new C();
//
//        obj4.fun2();
//        obj4.fun1();
//        obj4.fun();
//
//        System.out.println(obj4.d); // 20
//        System.out.println(obj4.d1); // 11
//        System.out.println(obj4.d2); // 21
//
//
//    }

//    public static void main(String[] args) {
////        add(1.0, 2.0);
////
////        add("Abc", "def");
////
////
////        add(1, 2, 3, 4, 5);
////        int x = add(346, 34, 3452, 53454, 312, 2453, 36, 46, 564, 34653645);
//
//            add(1);
//            add(1,2,3);
//            add(1,2);
//    }

//    public static void main(String[] args) {
//        C obj = new C(10);
//    }

//    public static void main(String[] args) {
//        CA ca = new CA();
//        ca.funA();
//        ca.fun();
//
//        add("abcd", "efgh");
//    }

    public static void main(String[] args) {
        P obj = new C();

        System.out.println(obj.d);
        System.out.println(obj.d1);
//        System.out.println(obj.d2);

        obj.fun();
        obj.fun1();

    }

    public static int add(int one, int two) {
        return one + two;
    }

    public static double add(double one, double two) {
        return one + two;
    }

    public static String add(String one, String two) {
        return one + two;
    }

//    public static void add(String one, String two) {
//        System.out.println(one + two);
//    }

    public static int add(int... vals) {
        int rv = 0;
        for (int i = 0; i < vals.length; i++) {
            rv += vals[i];
        }

        return rv;
    }
}

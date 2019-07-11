package lecture3;

/**
 * Created by piyush0 on 11/06/17.
 */
public class FunctionDemos {
    public static int XYZ = 20;

    public static int GLOBAL = 100; //10, 000

    public static void main(String[] args) {
        int one = 10;
        int two = 20;
        System.out.println(one + ", " + two);
        Swap(one, two);
        System.out.println(one + ", " + two);
    }

    public static void Swap(int one, int two) {
        System.out.println(one + ", " + two);

        int temp = one;
        one = two;
        two = temp;

        System.out.println(one + ", " + two);
    }

    public static void tweaker() {
        GLOBAL = 10000;
    }


    public static int DemoGlobalScopes(int one) {
        int sum = one + XYZ;
        return sum;
    }


    public static int DemoScopes(int one, int another) {
//		int one = 10;
//		int sum = one + two;
        int sum = one + another;
        return sum;
    }


    public static String HelloFunWithReturns(int msg) {
        String retVal = "I did your work";

        HelloFunWithParams(msg);

        return retVal;
    }

    public static void HelloFun() {
        System.out.println("Hello Fun");
    }

    public static void HelloGun() {
        System.out.println("Hello Gun");
    }

    public static void HelloNestedFun() {
        System.out.println("Hello Nested Fun");
        HelloFun();

        System.out.println("Hello Nested Fun");
        HelloGun();
    }

    public static void HelloFunWithParams(int msg) {
        System.out.println("Your message is : " + msg);
    }
}

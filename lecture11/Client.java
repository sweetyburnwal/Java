package lecture11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyush0 on 27/06/17.
 */
public class Client {
//    public static void main(String[] args) {
//        Person p1 = new Person();
//
//        p1.age = 10;
//        p1.name = "A";
//
//        System.out.println(p1.age);
//        System.out.println(p1.name);
//
//        Person p2 = p1;
//
//        p2.age = 20;
//        p2.name = "B";
//
//        System.out.println(p1.age);
//        System.out.println(p1.name);
//
//        Person p3 = new Person();
//
//        p3.age = 30;
//        p3.name = "C";
//
//        System.out.println("*** TEST 1 ***");
//
//        //p1.age = 20, p1.name = "B", p3.age =30, p3.name="C"
//
//        System.out.println(p1.age + ", " + p1.name);
//        System.out.println(p3.age + ", " + p3.name);
//        test1(p1, p3);
//        System.out.println(p1.age + ", " + p1.name);
//        System.out.println(p3.age + ", " + p3.name);
////
////        System.out.println("*** TEST 2 ***");
////
////        //p1.age = 20, p1.name = "B", p3.age =30, p3.name="C"
////
////        System.out.println(p1.age + ", " + p1.name);
////        System.out.println(p3.age + ", " + p3.name);
////        test2(p1, p3);
////        System.out.println(p1.age + ", " + p1.name);
////        System.out.println(p3.age + ", " + p3.name);
//
//        System.out.println("*** TEST 3 ***");
//
//        //p1.age = 20, p1.name = "B", p3.age =30, p3.name="C"
//
//
//        String name = "XYZ";
//        int age = 50;
//        System.out.println(p1.age + ", " + p1.name);
//        System.out.println(p3.age + ", " + p3.name);
//        test3(p1, p3.age, p3.name, age, name);
//        System.out.println(p1.age + ", " + p1.name);
//        System.out.println(p3.age + ", " + p3.name);
//        System.out.println(name + ", " + age);
//
//    }

//    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.name = "Xyz";
//        p1.age = 10;
//
//        Person p2 = new Person();
//        p2.name = "Abc";
//        p2.age = 20;
//
//        p1.growOld();
//
//        System.out.println(p1.age);
//        System.out.println(p2.age);
//
//    }

//    public static void main(String[] args) {
//        Person p = new Person();
//
//        p.age = -1;
//        System.out.println(p.age);
//
//
//    }

    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);

        int n = scrn.nextInt();
        scrn.nextLine();
        String str = scrn.nextLine();

        System.out.println(str);



    }

    public static void test3(Person p, int age, String name, int myAge, String myName) {
        p.age = 0;
        p.name = "_";
        age = 0;
        name = "_";
        myAge = 0;
        myName = "_";
    }

    public static void test2(Person p1, Person p2) {

        // Statement 2 : p1 = new Person();

        int tempa = p1.age;
        p1.age = p2.age;
        p2.age = tempa;

        // Statement 1 : p2 = new Person();

        String tempn = p1.name;
        p1.name = p2.name;
        p2.name = tempn;
    }

    public static void test1(Person p1, Person p2) {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }


}

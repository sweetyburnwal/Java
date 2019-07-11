package lecture15.generics;

import com.sun.tools.javac.jvm.Gen;
import lecture13.stacks.Stack;

import java.util.ArrayList;

/**
 * Created by piyush0 on 06/07/17.
 */
public class Client {
    public static void main(String[] args) {
//        RawPair rp = new RawPair();
//
//        rp.one = new ArrayList<>();
//
//        rp.two = 2;
//        rp.two = "Hello";
//        rp.two = 5.5;
//
//
//        System.out.println(((String) rp.two).length());


//        GenericPair<Integer> gp = new GenericPair<>();
//
//        gp.one = 3;
//        gp.two = 5;
//
//        MultiPair<Integer, String> mp = new MultiPair<>();
//
//        mp.one = 5;
//        mp.two = "hi";

        MultiPair<MultiPair<Integer, String>, MultiPair<String, Integer>> multiMp =
                new MultiPair<>();

        multiMp.one = new MultiPair<>();

        multiMp.one.one = 5;
        multiMp.one.two = "Hello";

        multiMp.two = new MultiPair<>();

        multiMp.two.one = "Bye";
        multiMp.two.two = 10;


        System.out.println(multiMp.one.two.length());

    }

}

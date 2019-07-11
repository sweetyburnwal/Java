package lecture7;

import java.util.ArrayList;

/**
 * Created by piyush0 on 18/06/17.
 */
public class ArrayListDemos {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        al.add(20);
        al.add(10);
        al.add(30);

        System.out.println(al.size());

        //getting
        System.out.println(al.get(1)); // [0, size()-1]

        //setting
        System.out.println(al.set(2, 300)); // // [0, size()-1]

        // sout
        System.out.println(al);

        //adding at index
        al.add(1,-1); // [0, size()]

        System.out.println(al);

        // remove
        al.remove(2); // [0, size()-1]
        System.out.println(al);
    }
}

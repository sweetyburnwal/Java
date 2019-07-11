package lecture14;

import java.util.Comparator;

/**
 * Created by piyush0 on 02/07/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
//        LinkedList ll = new LinkedList();

//        ll.addLast(30);
//        ll.display();
//
//        ll.addLast(40);
//        ll.display();
//
//        ll.addLast(50);
//        ll.display();
//
//        ll.addFirst(20);
//        ll.display();
//
//        ll.addFirst(10);
//        ll.display();
//
//        System.out.println(ll.getFirst());
//        System.out.println(ll.getLast());
//        System.out.println(ll.getAt(2));
//
//        ll.addAt(3,35);
//        ll.display();
//
//        System.out.println(ll.removeFirst());
//        ll.display();
//
//        System.out.println(ll.removeLast());
//        ll.display();
//
//        System.out.println(ll.removeAt(2));
//        ll.display();


//        ll.addLast(30);
//        ll.addLast(10);
//        ll.addLast(40);
//        ll.addLast(20);
//        ll.addLast(50);
//
//        System.out.println(ll.linearSearch(60));

//        ll.addLast(1);
//        ll.addLast(3);
//        ll.addLast(5);
//        ll.addLast(7);
//        ll.addLast(9);
//        ll.addLast(11);
//
//        LinkedList ll2 = new LinkedList();
//
//        ll2.addLast(2);
//        ll2.addLast(4);
//        ll2.addLast(6);
//        ll2.addLast(8);
//
//        LinkedList merged = ll.merge(ll2);
//        merged.display();

        LinkedList ll = new LinkedList();
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(2);
        ll.addLast(6);
        ll.addLast(1);
        ll.addLast(9);

        ll.kReverse(3);
        ll.display();
    }
}

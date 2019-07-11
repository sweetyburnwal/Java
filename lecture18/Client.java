package lecture18;

/**
 * Created by piyush0 on 11/07/17.
 */
public class Client {

    public static void main(String[] args) {
//        BST bst = new BST();
//
//        bst.add(50);
//        bst.add(25);
//        bst.add(75);
//        bst.add(12);
//        bst.add(37);
//        bst.add(62);
//        bst.add(87);
//
//        bst.display();
//
//        System.out.println(bst.max());
//        System.out.println(bst.min());
//        System.out.println(bst.find(61));
//        System.out.println(bst.find(62));
//
////        bst.remove(87);
////        bst.display();
////
////        bst.remove(75);
////        bst.display();
//
//
//        bst.remove(50);

        BST bst = new BST(12, 25, 37, 50, 62, 75, 87);
        bst.display();
        bst.printSumTarget(100);


    }
}

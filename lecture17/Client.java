package lecture17;

/**
 * Created by piyush0 on 09/07/17.
 */

// 10 true 20 true 40 false false false true 30 false true 70 false false

public class Client {
    public static void main(String[] args) {

//        bt.display();
//
//        System.out.println(bt.min());
//        System.out.println(bt.size2());
//        System.out.println(bt.max());
//        System.out.println(bt.find(100));
//        System.out.println(bt.find(60));
//        System.out.println(bt.height());

        int[] pre = {10, 20, 40, 50, 30, 60, 70,};
        int[] in = {40, 20, 50, 10, 60, 30, 70,};

        int[] pre2 = {50, 25, 12, 37, 75, 62, 87};
        int[] in2 = {12, 25, 37, 50, 62, 75, 87};

        BinaryTree bt = new BinaryTree(pre2, in2);
        bt.printKfar(37, 3);
    }
}

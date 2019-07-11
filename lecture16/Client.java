package lecture16;

import java.util.ArrayList;

/**
 * Created by piyush0 on 08/07/17.
 */
public class Client {
    // 10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0

    public static void main(String[] args) {


        GenericTree gt = new GenericTree();

//        gt.display();

//        System.out.println(gt.size2());
//        System.out.println(gt.find(100));
//        System.out.println(gt.find(-100));
//        System.out.println(gt.max());
//        System.out.println(gt.height());

//        gt.display();
//        System.out.println(gt.isIsomorphic(gt));

//        gt.preOrder();
//        gt.postOrder();
//
//        gt.levelOrder();


        gt.display();
        gt.replaceWD();
        System.out.println("~~~~~~~~~~");
        gt.display();

    }


}

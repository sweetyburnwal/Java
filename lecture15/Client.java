package lecture15;

import lecture14.LinkedList;
import lecture15.generics.GenericPair;
import lecture4.ArraysDemo;

import java.util.ArrayList;

/**
 * Created by piyush0 on 06/07/17.
 */
public class Client {

//    public static void main(String[] args) {
//        int[] arr = {5, 2, 7, 3, 1};
//
//        bubbleSort(arr);
//        display(arr);
//
//        double[] doubles = {4.4, 1.1, 3.3, 2.2};

//        int[] arr = new int[4];
//
//        System.out.println(arr);

//        LinkedList ll = new LinkedList();
//
//        ll.addLast(10);
//        ll.addLast(20);
//        ll.addLast(30);
//        ll.addLast(40);
//        ll.addLast(50);
//        ll.addLast(60);
//
//        System.out.println(ll);
//
//    }


//    public static void main(String[] args) throws Exception {
////        IStack stack = new StackUsingLL();
////
////        stack.push(10);
////        stack.display();
////
////        stack.push(20);
////        stack.display();
////
////        stack.push(30);
////        stack.display();
////
////        stack.push(40);
////        stack.display();
////
////        System.out.println(stack.top());
////        System.out.println(stack.pop());
////        stack.display();
//
//
//        IQueue queue = new QueueUsingLL();
//
//        queue.enqueue(10);
//        queue.display();
//
//        queue.enqueue(20);
//        queue.display();
//
//        queue.enqueue(30);
//        queue.display();
//
//        queue.enqueue(40);
//        queue.display();
//
//        System.out.println(queue.front());
//        System.out.println(queue.dequeue());
//        queue.display();
//
//        System.out.println(queue.front());
//        System.out.println(queue.dequeue());
//        queue.display();
//
//        System.out.println(queue.front());
//        System.out.println(queue.dequeue());
//        queue.display();
//
//        System.out.println(queue.front());
//        System.out.println(queue.dequeue());
//        queue.display();
//
//        System.out.println(queue.front());
//        System.out.println(queue.dequeue());
//        queue.display();
//    }


    public static void main(String[] args) {
//        Integer[] arr = {5, 2, 7, 3, 1};
////
//        bubbleSort(arr);
//        display(arr);
//
//
        Double[] doubles = {4.4, 1.1, 3.3, 2.2};
        bubbleSort(doubles);
        display(doubles);
//
        String[] strings = {"abcd", "defg", "a", "qwer"};
//        bubbleSort(strings);
//        display(strings);

//        Car[] cars = new Car[5];
//        cars[0] = new Car("Q", 10, 100);
//        cars[1] = new Car("A", 100, 10);
//        cars[2] = new Car("W", 1000, 0);
//        cars[3] = new Car("P", -10, 20);
//        cars[4] = new Car("E", 20, 200);
//
//        bubbleSort(cars);
//        display(cars);

        GenericLinkedList<Car> carList = new GenericLinkedList<>();

        carList.addLast(new Car("Q", 10, 100));
        carList.addLast(new Car("A", 100, 10));
        carList.addLast(new Car("W", 1000, 0));
        carList.addLast(new Car("P", -10, 20));
        carList.addLast(new Car("E", 20, 200));

        System.out.println(carList);

    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {

                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    public static <T> void display(T[] arr) {
        for (T val : arr) {
            System.out.print(val + ", ");
        }
        System.out.println("END");
    }

}

package lecture12;

import lecture13.queues.Queue;

/**
 * Created by piyush0 on 29/06/17.
 */
public class QueueClient {

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.display();

        queue.enqueue(20);
        queue.display();

        queue.enqueue(30);
        queue.display();

        queue.enqueue(40);
        queue.display();

        queue.enqueue(50);
        queue.display();

//        queue.enqueue(60);
//        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();

        queue.enqueue(60);
        queue.display();

        queue.enqueue(70);
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        queue.display();


        queue.display();
        reverse(queue);
        queue.display();

    }

    public static void reverse(Queue queue){

    }

}

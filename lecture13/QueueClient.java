package lecture13;

import lecture13.queues.DynamicQueue;
import lecture13.queues.Queue;

/**
 * Created by piyush0 on 01/07/17.
 */
public class QueueClient {
    public static void main(String[] args) throws Exception {
        Queue queue = new DynamicQueue();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();


        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();


        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();


        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();

        queue.enqueue(10);
        queue.display();


        queue.enqueue(10);
        queue.display();
    }
}

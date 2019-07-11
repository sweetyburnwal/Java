package lecture15;

/**
 * Created by piyush0 on 06/07/17.
 */
public interface IQueue {

    void display();

    int size();

    boolean isEmpty();

    void enqueue(int item);

    int front() throws Exception;

    int dequeue() throws Exception;
}

package lecture15;

/**
 * Created by piyush0 on 06/07/17.
 */
public interface IStack {

    int size();

    boolean isEmpty();

    void display();

    void push(int item);

    int top() throws Exception;

    int pop() throws Exception;

}

package lecture13.stacks;
/**
 * Created by piyush0 on 29/06/17.
 */
public class Stack {
    protected int[] data;
    protected int tos;

    public static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        this.data = new int[capacity];
        this.tos = -1;
    }

    public int size() {
        return this.tos + 1;
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {

        for (int i = this.tos; i >= 0; i--) {
            System.out.print(this.data[i] + ", ");
        }

        System.out.println("END");
    }

    public void push(int item) throws Exception {
        if (this.size() == this.data.length) {
            throw new Exception("Stack is full");
        }


        this.tos++;
        this.data[this.tos] = item;
    }

    public int top() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        return this.data[this.tos];
    }

    public int pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        int rv = this.data[this.tos];

        this.data[this.tos] = 0;
        this.tos--;

        return rv;

    }


}

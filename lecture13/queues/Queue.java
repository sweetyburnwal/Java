package lecture13.queues;
/**
 * Created by piyush0 on 29/06/17.
 */
public class Queue {
    protected int[] data;
    protected int front;
    protected int size;

    public static final int DEFAULT_CAPACITY = 10;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        this.data = new int[capacity];
        this.front = 0;
        this.size = 0;

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void display() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.data[(i + front) % this.data.length] + ", ");
        }
        System.out.println("END");
    }

    public void enqueue(int item) throws Exception {
        if (this.size() == this.data.length) {
            throw new Exception("Queue is full");
        }

        int rear = (this.front + this.size) % this.data.length;
        this.data[rear] = item;
        this.size++;

    }

    public int front() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        return this.data[this.front];
    }

    public int dequeue() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        int rv = this.data[this.front];

        this.data[this.front] = 0;
        this.front = (this.front + 1) % this.data.length;
        this.size--;

        return rv;
    }

}

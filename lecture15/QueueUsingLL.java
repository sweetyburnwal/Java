package lecture15;

import lecture14.LinkedList;

/**
 * Created by piyush0 on 06/07/17.
 */
public class QueueUsingLL implements IQueue {

    private LinkedList list;

    public QueueUsingLL() {
        this.list = new LinkedList();
    }

    @Override
    public void display() {
        System.out.println(this.list);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void enqueue(int item) {
        this.list.addLast(item);
    }

    @Override
    public int front() throws Exception {
        try {
            return this.list.getFirst();
        } catch (Exception ex) {
            System.out.println("Queue is empty");
        }

        return 0;
    }

    @Override
    public int dequeue() throws Exception {
        try {
            return this.list.removeFirst();
        } catch (Exception ex) {
            System.out.println("Queue is empty");
        }

        return 0;
    }
}

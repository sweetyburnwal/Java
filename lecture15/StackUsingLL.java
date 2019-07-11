package lecture15;

import lecture14.LinkedList;

/**
 * Created by piyush0 on 06/07/17.
 */
public class StackUsingLL implements IStack {

    private LinkedList list;



    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void display() {
        System.out.println(this.list);
    }

    @Override
    public void push(int item) {
        this.list.addFirst(item);
    }

    @Override
    public int top() throws Exception {
        return this.list.getFirst();
    }

    @Override
    public int pop() throws Exception {
        return this.list.removeFirst();
    }
}

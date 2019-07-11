package asgn_SnQ;

import lecture13.stacks.DynamicStack;
import lecture13.stacks.Stack;

/**
 * Created by piyush0 on 11/07/17.
 */
public class QUSi {

    private Stack pStack;
    private Stack sStack;

    public QUSi() {
        this.pStack = new DynamicStack();
        this.sStack = new DynamicStack();
    }

    public void display() {
        this.pStack.display();
    }

    public void enqueue(int item) throws Exception {
        this.pStack.push(item);
    }

    public int front() throws Exception {
        while (!this.pStack.isEmpty()) {
            this.sStack.push(this.pStack.pop());
        }

        int rv = this.sStack.top();

        while (!this.sStack.isEmpty()) {
            this.pStack.push(this.sStack.pop());
        }

        return rv;
    }

    public int dequeue() throws Exception {

        while (!this.pStack.isEmpty()) {
            this.sStack.push(this.pStack.pop());
        }

        int rv = this.sStack.pop();

        while (!this.sStack.isEmpty()) {
            this.pStack.push(this.sStack.pop());
        }

        return rv;

    }

}

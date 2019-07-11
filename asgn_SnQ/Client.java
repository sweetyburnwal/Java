package asgn_SnQ;

import lecture13.queues.Queue;
import lecture13.stacks.DynamicStack;
import lecture13.stacks.Stack;
import lecture4.ArraysQuestions;

/**
 * Created by piyush0 on 11/07/17.
 */
public class Client {
    public static void main(String[] args) throws Exception {
//        QUSi quSi = new QUSi();
//
//        quSi.enqueue(10);
//        quSi.display();
//
//        quSi.enqueue(20);
//        quSi.display();
//
//        quSi.enqueue(30);
//        quSi.display();
//
//        quSi.enqueue(40);
//        quSi.display();
//
//        System.out.println(quSi.front());
//        System.out.println(quSi.dequeue());
//
//        quSi.display();
        Stack stack = new DynamicStack();

        stack.push(10);
        stack.push(1);
        stack.push(88);
        stack.push(5);
        stack.push(2);
        stack.display();
        sortAStack(stack);
        stack.display();
    }

    public static void reverse(Queue queue) throws Exception {
        if (queue.isEmpty()) {
            return;
        }

        int temp = queue.dequeue();
        reverse(queue);
        queue.enqueue(temp);

    }

    public static boolean duplicate(String str) throws Exception {

        Stack stack = new DynamicStack();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != ')') {
                stack.push(str.charAt(i));
            } else {
                int count = 0;
                while (stack.top() != '(') {
                    stack.pop();
                    count++;
                }

                if (count == 0) {
                    return true;
                } else {
                    stack.pop();
                }


            }

        }

        return false;
    }

    public static int[] stockSpan(int[] prices) throws Exception {

        int[] rv = new int[prices.length];
        rv[0] = 0;

        Stack stack = new DynamicStack();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[i] > prices[stack.top()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rv[i] = i;
            } else {
                rv[i] = i - stack.top() - 1;
            }

            stack.push(i);

        }


        return rv;

    }

    public static void sortAStack(Stack stack) throws Exception {
        Stack helper = new DynamicStack();

        for (int i = 0; i < stack.size(); i++) {

            int max = Integer.MIN_VALUE;

            while (stack.size() != i) {
                int val = stack.pop();
                if (val > max) {
                    max = val;
                }
                helper.push(val);
            }

            stack.push(max);

            while (!helper.isEmpty()) {
                int val = helper.pop();
                if (val != max) {
                    stack.push(val);
                }
            }

        }
    }
}

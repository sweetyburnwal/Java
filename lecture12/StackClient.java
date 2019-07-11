package lecture12;

import lecture13.stacks.Stack;

/**
 * Created by piyush0 on 29/06/17.
 */
public class StackClient {
//    public static void main(String[] args) throws Exception {
//        Stack stack = new Stack(5);
//
//        stack.push(5);
//        stack.display();
//
//        stack.push(6);
//        stack.display();
//
//        stack.push(7);
//        stack.display();
//
//        stack.push(8);
//        stack.display();
//
//        stack.push(9);
//        stack.display();
//
////        stack.push(10);
////        stack.display();
//
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        stack.display();
//
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        stack.display();
//
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        stack.display();
//
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        stack.display();
//
//
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        stack.display();
//
////        System.out.println(stack.top());
////        System.out.println(stack.pop());
////        stack.display();
//
//        stack.display();
//        printStackInReverse(stack);
//        stack.display();
//
////        System.out.println(maxInStack(stack));
////        stack.display();
////
////        stack.display();
////        sortAStack(stack);
////        stack.display();
//    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);

        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);

        stack.display();
        printStackInReverse(stack);
        System.out.println();
        stack.display();
    }


    public static void printStackInReverse(Stack stack) throws Exception {
        if (stack.isEmpty()) {
            return;
        }

        int val = stack.pop();
        printStackInReverse(stack);
        System.out.print(val + ", ");
        stack.push(val);

    }

    public static int maxInStack(Stack stack) throws Exception {

        if (stack.size() == 1) {
            return stack.top();
        }

        int val = stack.pop();
        int recResult = maxInStack(stack);
        stack.push(val);

        if (val > recResult) {
            return val;
        } else {
            return recResult;
        }
    }

    public static void sortAStack(Stack stack) {

    }
}

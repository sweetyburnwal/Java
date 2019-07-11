package lecture15;

/**
 * Created by piyush0 on 06/07/17.
 */
public class GenericLinkedList<T extends Comparable<T>> {
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public String toString() {
        String rv = "";

        Node temp = this.head;

        while (temp != null) {
            rv += temp.data + ", ";
            temp = temp.next;
        }

        rv += "END\n";

        return rv;
    }

    // O(1)
    public int size() {
        return this.size;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // O(n) vs O(n) in AL
    public void display() {
        Node toBePrinted = this.head;

        for (int i = 0; i < this.size(); i++) {
            System.out.print(toBePrinted.data + " => ");
            toBePrinted = toBePrinted.next;
        }

        System.out.println("END size : " + this.size());
    }

    // O(1) vs O(n) in AL
    public void addFirst(T item) {
        Node newHead = new Node(item, this.head);

        if (this.isEmpty()) {
            this.tail = newHead;
        }

        this.head = newHead;

        this.size++;
    }

    // O(1) vs O(1) in AL
    public void addLast(T item) {
        if (this.isEmpty()) {
            this.addFirst(item);
        } else {

            Node newTail = new Node(item, null);

            this.tail.next = newTail;
            this.tail = newTail;

            this.size++;
        }
    }

    // O(n) vs O(n) in AL
    public void addAt(int idx, T item) throws Exception {
        if (idx < 0 || idx > this.size()) {
            throw new Exception("Index out of bound");
        }

        if (idx == 0) {
            this.addFirst(item);
        } else if (idx == this.size()) {
            this.addLast(item);
        } else {

            Node nm1 = this.getNodeAt(idx - 1);
            Node np1 = nm1.next;

            Node newNode = new Node(item, np1);
            nm1.next = newNode;

            this.size++;

        }
    }

    // O(1) vs O(1) in AL
    public T getFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        return this.head.data;

    }

    // O(1) vs O(1) in AL
    public T getLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        return this.tail.data;
    }

    // O(n) vs O(1) in AL
    public T getAt(int idx) throws Exception {
        return this.getNodeAt(idx).data;
    }

    // O(n) vs O(1) in AL
    private Node getNodeAt(int idx) throws Exception {
        if (idx < 0 || idx >= this.size()) {
            throw new Exception("Index out of bound");
        }

        if (idx == this.size() - 1) {
            return this.tail;
        }

        Node rv = this.head;

        for (int i = 0; i < idx; i++) {
            rv = rv.next;
        }

        return rv;

    }

    // O(1) vs O(n) in AL
    public T removeFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        T rv = this.head.data;

        this.head = this.head.next;

        if (this.size() == 1) {
            this.tail = null;
        }

        this.size--;
        return rv;
    }

    // O(n) vs O(1) in AL
    public T removeLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        T rv = this.tail.data;

        if (this.size() == 1) {
            this.head = this.tail = null;
        } else {
            Node sm2 = this.getNodeAt(this.size() - 2);
            sm2.next = null;
            this.tail = sm2;
        }


        this.size--;

        return rv;

    }

    // O(n) vs O(n) in AL
    public T removeAt(int idx) throws Exception {
        if (idx < 0 || idx >= this.size()) {
            throw new Exception("Index out of bound");
        }

        if (idx == 0) {
            return this.removeFirst();
        } else if (idx == this.size() - 1) {
            return this.removeLast();
        } else {

            Node nm1 = this.getNodeAt(idx - 1);
            Node n = nm1.next;
            Node np1 = n.next;

            nm1.next = np1;
            this.size--;

            return n.data;
        }
    }

    // O(n)
    public int linearSearch(T item) {
        Node toBeChecked = this.head;

        for (int i = 0; i < this.size(); i++) {
            if (toBeChecked.data.equals(item)) {
                return i;
            }
            toBeChecked = toBeChecked.next;
        }

        return -1;


    }

    // O(n^2)
    public void reverseDI() throws Exception {

        int left = 0;
        int right = this.size() - 1;

        while (left <= right) {

            Node leftNode = this.getNodeAt(left);
            Node rightNode = this.getNodeAt(right);

            T temp = leftNode.data;
            leftNode.data = rightNode.data;
            rightNode.data = temp;


            left++;
            right--;
        }

    }

    // O(n)
    public void reversePI() {

        Node prev = this.head;
        Node curr = this.head.next;

        while (curr != null) {

            Node temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;

        }

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        this.tail.next = null;

    }

    public void reverseDisplay() {
        this.reverseDisplay(this.head);
    }

    private void reverseDisplay(Node node) {

        if (node == null) {
            return;
        }

        this.reverseDisplay(node.next);
        System.out.print(node.data + ", ");
    }

    // O(n)
    public void reversePR() {
        this.reversePR(this.head, this.head.next);

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        this.tail.next = null;
    }

    // O(n)
    private void reversePR(Node prev, Node curr) {

        if (curr == null) {
            return;
        }
        this.reversePR(prev.next, curr.next);

        curr.next = prev;

    }

    // O(n)
    public void reverseDR() {
        NodeHeap left = new NodeHeap();
        left.node = this.head;

        this.reverseDR(left, this.head, 0);
    }

    //    private void reverseDR(Node left, Node right) {
//
//        if (right == null) {
//            return;
//        }
//
//        this.reverseDR(left, right.next);
//
//        int temp = left.data;
//        left.data = right.data;
//        right.data = temp;
//
//        left = left.next;
//    }
    private class NodeHeap {
        Node node;
    }

    private void reverseDR(NodeHeap left, Node right, int count) {

        if (right == null) {
            return;

        }

        this.reverseDR(left, right.next, count + 1);


        if (count >= this.size() / 2) {
            T temp = left.node.data;
            left.node.data = right.data;
            right.data = temp;

            left.node = left.node.next;
        }
    }

    public int headVsTail() {
        if (this.head.data.compareTo(this.tail.data) > 0) {
            return 1;
        } else if (this.head.data.compareTo(this.tail.data) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}

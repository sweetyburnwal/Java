package lecture14;

/**
 * Created by piyush0 on 02/07/17.
 */
public class LinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data, Node next) {
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
    public void addFirst(int item) {
        Node newHead = new Node(item, this.head);

        if (this.isEmpty()) {
            this.tail = newHead;
        }

        this.head = newHead;

        this.size++;
    }

    // O(1) vs O(1) in AL
    public void addLast(int item) {
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
    public void addAt(int idx, int item) throws Exception {
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
    public int getFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        return this.head.data;

    }

    // O(1) vs O(1) in AL
    public int getLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        return this.tail.data;
    }

    // O(n) vs O(1) in AL
    public int getAt(int idx) throws Exception {
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
    public int removeFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        int rv = this.head.data;

        this.head = this.head.next;

        if (this.size() == 1) {
            this.tail = null;
        }

        this.size--;
        return rv;
    }

    // O(n) vs O(1) in AL
    public int removeLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }

        int rv = this.tail.data;

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
    public int removeAt(int idx) throws Exception {
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
    public int linearSearch(int item) {
        Node toBeChecked = this.head;

        for (int i = 0; i < this.size(); i++) {
            if (toBeChecked.data == item) {
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

            int temp = leftNode.data;
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
        NodeHeap left = new NodeHeap(this.head);

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

        public NodeHeap(Node node) {
            this.node = node;
        }
    }

    private void reverseDR(NodeHeap left, Node right, int count) {

        if (right == null) {
            return;

        }

        this.reverseDR(left, right.next, count + 1);


        if (count >= this.size() / 2) {
            int temp = left.node.data;
            left.node.data = right.data;
            right.data = temp;

            left.node = left.node.next;
        }
    }

    public int headVsTail() {
        if (this.head.data > this.tail.data) {
            return 1;
        } else if (this.head.data == this.tail.data) {
            return 0;
        } else {
            return -1;
        }
    }

    public void swapNodes(int num1, int num2) {
        if (num1 == num2) return;

        Node prev1 = null, curr1 = head;
        while (curr1 != null && curr1.data != num1) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        Node prev2 = null, curr2 = head;
        while (curr2 != null && curr2.data != num2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) {
            return;
        }

        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }


        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1;
        }


        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

        if (curr1.next == null) {
            this.tail = curr1;
        }

        if (curr2.next == null) {
            this.tail = curr2;
        }

    }

    public void eliminateDuplicates() {
        Node prev = this.head;
        Node curr = prev.next;

        while (curr != null) {

            if (prev.data == curr.data) {
                prev.next = curr.next;
                this.size--;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }

        }

        this.tail = prev;
        this.tail.next = null;


    }

    public LinkedList merge(LinkedList other) {
        LinkedList retVal = new LinkedList();

        Node myNode = this.head;
        Node otherNode = other.head;

        while (myNode != null && otherNode != null) {
            if (myNode.data < otherNode.data) {
                retVal.addLast(myNode.data);
                myNode = myNode.next;
            } else {
                retVal.addLast(otherNode.data);
                otherNode = otherNode.next;
            }
        }

        while (myNode != null) {
            retVal.addLast(myNode.data);
            myNode = myNode.next;
        }

        while (otherNode != null) {
            retVal.addLast(otherNode.data);
            otherNode = otherNode.next;
        }

        return retVal;
    }

    public int mid() {
        return this.midNode().data;
    }

    private Node midNode() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    private void selectionSort(Node i, Node j) {

        if (i.next == null) {
            return;
        }

        if (j == null) {
            selectionSort(i.next, i.next.next);
            return;
        }

        if (i.data > j.data) {
            int temp = i.data;
            i.data = j.data;
            j.data = temp;
        }

        selectionSort(i, j.next);
    }

    private void selectionSortI() {

        for (Node i = this.head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }

    }

    public boolean isPalindrome() {
        return this.isPalindrome(new NodeHeap(this.head), this
                .head);
    }

    private boolean isPalindrome(NodeHeap left, Node right) {

        if (right == null) {
            return true;
        }
        boolean recResult = isPalindrome(left, right.next);

        if (left.node.data != right.data) {
            return false;
        } else {
            left.node = left.node.next;
            return recResult;
        }
    }

    public LinkedList mergeSort() {

        if (this.size == 1) {
            return this;
        }

        Node midNode = this.midNode();
        Node midNext = midNode.next;


        LinkedList fh = new LinkedList();

        fh.head = this.head;
        fh.tail = midNode;
        fh.tail.next = null;
        fh.size = (this.size() + 1) / 2;

        LinkedList sh = new LinkedList();
        sh.head = midNext;
        sh.tail = this.tail;
        sh.size = this.size() / 2;

        fh = fh.mergeSort();
        sh = sh.mergeSort();

        LinkedList retVal = fh.merge(sh);


        midNode.next = midNext;
        return retVal;


    }

    public void evenAfterOdd() {
        int countEven = 0;

        for (Node temp = this.head.next; temp != null; temp = temp.next) {
            if (temp.data % 2 == 0) {
                countEven++;
            }
        }

        Node prev = this.head;
        Node curr = prev.next;

        int i = 0;




        while (i < countEven) {

            if (curr.data % 2 == 0) {
                prev.next = curr.next;

                this.tail.next = curr;
                this.tail = curr;
                curr.next = null;

                i++;
                curr = prev.next;

            } else {
                prev = prev.next;
                curr = curr.next;
            }

        }


        if (this.head.data % 2 == 0) {

            Node newHead = this.head.next;

            this.tail.next = this.head;
            this.tail = this.head;
            this.tail.next = null;

            this.head = newHead;
        }

    }

    public void append(int n) {

        Node curr = this.head;

        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        Node prev = this.head;

        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }

        curr.next = this.head;

        this.head = prev.next;

        prev.next = null;
        this.tail = prev;


    }

    public void kReverse(int k) throws Exception {

        LinkedList prev = null;
        LinkedList curr = new LinkedList();

        while (!this.isEmpty()) {

            for (int i = 0; !this.isEmpty() && i < k; i++) {
                curr.addFirst(this.removeFirst());
            }

            if (prev == null) {
                prev = curr;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size();
            }

            curr = new LinkedList();

        }



        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
    }

}

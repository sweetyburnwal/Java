package lecture18;

import java.util.Stack;

/**
 * Created by piyush0 on 11/07/17.
 */
public class BST {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public BST(int... sa) {
        this.root = construct(sa, 0, sa.length - 1);
    }

    private Node construct(int[] sa, int si, int li) {

        if (si > li) {
            return null;
        }

        int mid = (si + li) / 2;

        Node node = new Node(sa[mid], null, null);
        this.size++;

        node.left = this.construct(sa, si, mid - 1);
        node.right = this.construct(sa, mid + 1, li);

        return node;

    }

    public BST() {

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(int item) {
        if (this.isEmpty()) {
            this.root = new Node(item, null, null);
            this.size++;
        } else {
            this.add(item, this.root);
        }

    }

    private void add(int item, Node node) {

        if (item > node.data) {
            if (node.right == null) {
                node.right = new Node(item, null, null);
                this.size++;
            } else {
                this.add(item, node.right);
            }
        } else if (item < node.data) {
            if (node.left == null) {
                node.left = new Node(item, null, null);
                this.size++;
            } else {
                this.add(item, node.left);
            }
        } else {
            // nothing
        }
    }

    public void remove(int item) {
        this.remove(item, this.root, null, false);
    }

    private void remove(int item, Node node,
                        Node parent, boolean ilc) {

        if (node == null) {
            return;
        }

        if (item > node.data) {
            this.remove(item, node.right, node, false);
        } else if (item < node.data) {
            this.remove(item, node.left, node, true);
        } else {

            // node.data == item

            if (node.left != null && node.right != null) {

                int lMax = this.max(node.left);
                node.data = lMax;
                this.remove(lMax, node.left, node, true);

            } else if (node.left != null) {

                if (ilc) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }

                this.size--;

            } else if (node.right != null) {

                if (ilc) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }

                this.size--;

            } else {


                if (ilc) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }

                this.size--;
            }
        }

    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null) {
            System.out.print("END => ");
        } else {
            System.out.print(node.left.data + " => ");
        }

        System.out.print(node.data);

        if (node.right == null) {
            System.out.print(" <= END");
        } else {
            System.out.print(" <= " + node.right.data);
        }

        System.out.println();

        this.display(node.left);
        this.display(node.right);
    }

    public int size2() {
        return this.size2(this.root);
    }

    private int size2(Node node) {

        if (node == null) {
            return 0;
        }

        int lsize = this.size2(node.left);
        int rsize = this.size2(node.right);
        return lsize + rsize + 1;
    }


    public int max() {
        return this.max(this.root);
    }

    private int max(Node node) {
        if (node.right == null) {
            return node.data;
        }

        return this.max(node.right);
    }

    public int min() {
        return this.min(this.root);
    }

    private int min(Node node) {
        if (node.left == null) {
            return node.data;
        }

        return this.min(node.left);
    }

    public boolean find(int item) {
        return this.find(item, this.root);
    }

    private boolean find(int item, Node node) {

        if (node == null) {
            return false;
        }

        if (node.data == item) {
            return true;
        }

        if (item > node.data) {
            return this.find(item, node.right);
        } else {
            return this.find(item, node.left);
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = this.height(node.left);
        int rh = this.height(node.right);

        return Math.max(lh, rh) + 1;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + ", ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void postOrder() {
        this.postOrder(this.root);
        System.out.println("END");
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + ", ");

    }

    public void inOrder() {
        this.inOrder(this.root);
        System.out.println("END");
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        this.inOrder(node.left);

        System.out.print(node.data + ", ");

        this.inOrder(node.right);

    }

    public int diameter() {
        return this.diameter(this.root);
    }

    private int diameter(Node node) {

        if (node == null) {
            return 0;
        }

        int f1 = this.height(node.left) + this.height(node.right) + 2;
        int f2 = this.diameter(node.left);
        int f3 = this.diameter(node.right);

        return Math.max(f1, Math.max(f2, f3));
    }

    private class DiaPair {
        int height;
        int diameter;
    }

    private DiaPair diameterBtr(Node node) {

        if (node == null) {
            DiaPair basePair = new DiaPair();
            basePair.diameter = 0;
            basePair.height = -1;
            return basePair;
        }

        DiaPair lr = this.diameterBtr(node.left);
        DiaPair rr = this.diameterBtr(node.right);

        DiaPair retVal = new DiaPair();

        retVal.height = Math.max(lr.height, rr.height) + 1;

        int f1 = lr.height + rr.height + 2;
        int f2 = lr.diameter;
        int f3 = rr.diameter;

        retVal.diameter = Math.max(f1, Math.max(f2, f3));

        return retVal;

    }

    public int diameterBtr() {
        return this.diameterBtr(this.root).diameter;
    }

    public void createDuplicate() {
        this.createDuplicate(this.root);
    }

    private void createDuplicate(Node node) {
        if (node == null) {
            return;
        }

        node.left = new Node(node.data, node.left, null);
        this.size++;

        this.createDuplicate(node.left.left);
        this.createDuplicate(node.right);

    }

    public int lca(int num1, int num2) {
        if (num2 < num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return this.lca(num1, num2, this.root).data;
    }

    // num1 < num2
    private Node lca(int num1, int num2, Node node) {

        if (node == null) {
            return null;
        }

        if (node.data > num2) {
            return this.lca(num1, num2, node.left);
        } else if (node.data < num1) {
            return this.lca(num1, num2, node.right);
        } else {
            return node;
        }


    }

    public void replaceWG() {
        replaceWG(this.root, new SumHeap());
    }

    private void replaceWG(Node node, SumHeap sumHeap) {

        if (node == null) {
            return;
        }

        replaceWG(node.right, sumHeap);


        // work
        int temp = node.data;
        node.data = sumHeap.sum;
        sumHeap.sum += temp;


        replaceWG(node.left, sumHeap);
    }

    private class SumHeap {
        int sum;
    }

    public void printSumTarget(int target) {

        Stack<Node> stackLeft = new Stack<>();
        Stack<Node> stackRight = new Stack<>();

        Node nodeLeft = this.root, nodeRight = this.root;
        int valueLeft = 0, valueRight = 0;
        boolean doneLeft = false, doneRight = false;


        while (true) {

            while (!doneLeft) {

                if (nodeLeft != null) {
                    stackLeft.push(nodeLeft);
                    nodeLeft = nodeLeft.left;
                } else {

                    nodeLeft = stackLeft.pop();
                    valueLeft = nodeLeft.data;

                    nodeLeft = nodeLeft.right;

                    doneLeft = true;

                }

            }

            while (!doneRight) {

                if (nodeRight != null) {
                    stackRight.push(nodeRight);
                    nodeRight = nodeRight.right;
                } else {

                    nodeRight = stackRight.pop();
                    valueRight = nodeRight.data;
                    nodeRight = nodeRight.left;

                    doneRight = true;

                }

            }

            if (valueLeft > valueRight) {
                return;
            }

            if (valueLeft + valueRight < target) {
                doneLeft = false;
            }

            if (valueLeft + valueRight > target) {
                doneRight = false;
            }

            if (valueLeft + valueRight == target) {
                System.out.println(valueLeft + " " + valueRight);
                doneLeft = false;
                doneRight = false;
            }


        }

    }
}

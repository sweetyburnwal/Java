package lecture17;

import java.util.LinkedList;
import java.util.Scanner;

import java.util.*;

/**
 * Created by piyush0 on 09/07/17.
 */
public class BinaryTree {

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

    public BinaryTree() {
        Scanner scrn = new Scanner(System.in);
        this.root = this.construct(scrn, null, false);
    }

    public BinaryTree(int[] pre, int[] in) {
        this.root = this.construct(pre, 0, pre.length - 1,
                in, 0, in.length - 1);
    }

    private Node construct(int[] pre, int psi, int pli,
                           int[] in, int isi, int ili) {

        if (psi > pli || isi > ili) {
            return null;
        }

        Node node = new Node(pre[psi], null, null);
        this.size++;

        int searchIndex = -1;

        for (int i = isi; i <= ili; i++) {
            if (node.data == in[i]) {
                searchIndex = i;
                break;

            }
        }

        int ne = searchIndex - isi;

        node.left = this.construct(pre, psi + 1, psi + ne,
                in, isi, searchIndex - 1);
        node.right = this.construct(pre, psi + ne + 1, pli,
                in, searchIndex + 1, ili);


        return node;

    }

    private Node construct(Scanner scrn, Node parent, boolean isLeft) {

        if (parent == null) {
            System.out.println("Enter the data for root");
        } else {
            if (isLeft) {
                System.out.println("Enter the data for" +
                        " left child of " + parent.data);
            } else {
                System.out.println("Enter the data for" +
                        " right child of " + parent.data);
            }
        }

        int childData = scrn.nextInt();

        Node child = new Node(childData, null, null);
        this.size++;


        System.out.println("Do you have a left child ? " + child.data);
        boolean choice = scrn.nextBoolean();

        if (choice) {
            child.left = this.construct(scrn, child, true);
        }

        System.out.println("Do you have a right child ? " + child.data);
        choice = scrn.nextBoolean();

        if (choice) {
            child.right = this.construct(scrn, child, false);
        }

        return child;
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

    private int min(Node node) {

        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int lMin = this.min(node.left);
        int rMin = this.min(node.right);

        return Math.min(node.data, Math.min(lMin, rMin));

    }

    public int min() {
        return this.min(this.root);
    }

    public int max() {
        return this.max(this.root);
    }

    private int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lMax = this.max(node.left);
        int rMax = this.max(node.right);

        return Math.max(node.data, Math.max(lMax, rMax));

    }

    public boolean find(int item) {
        return this.find(this.root, item);
    }

    private boolean find(Node node, int item) {

        if (node == null) {
            return false;
        }

        if (node.data == item) {
            return true;
        }

        boolean lResult = this.find(node.left, item);

        if (lResult) {
            return true;
        }

        boolean rResult = this.find(node.right, item);

        return rResult;

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

    public void levelOrder() {
        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        System.out.println("END");
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

    public boolean isBST() {
        return this.isBST(this.root);
    }

    private boolean isBST(Node node) {
        if (node == null) {
            return true;
        }

        int lMax = this.max(node.left);
        int rMin = this.min(node.right);

        if (node.data < lMax) {
            return false;
        }

        if (node.data > rMin) {
            return false;
        }

        boolean isLeftBST = this.isBST(node.left);
        boolean isRightBST = this.isBST(node.right);

        return isLeftBST && isRightBST;

    }

    private class BSTtriplet {
        boolean isBST;
        int min;
        int max;
    }

    public boolean isBSTbtr() {

        return this.isBST2(this.root).isBST;
    }

    private BSTtriplet isBST2(Node node) {

        if (node == null) {
            BSTtriplet br = new BSTtriplet();
            br.isBST = true;
            br.max = Integer.MIN_VALUE;
            br.min = Integer.MAX_VALUE;
            return br;
        }

        BSTtriplet lr = this.isBST2(node.left);
        BSTtriplet rr = this.isBST2(node.right);

        BSTtriplet mr = new BSTtriplet();

        if (!lr.isBST || !rr.isBST || node.data < lr.max
                || node.data > rr.min) {
            mr.isBST = false;
        } else {
            mr.isBST = true;
        }

        mr.max = Math.max(node.data, Math.max(lr.max, rr.max));
        mr.min = Math.min(node.data, Math.min(lr.min, rr.min));

        return mr;

    }


    public boolean isBST3() {
        return this.isBST3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST3(Node node, int min, int max) {

        if (node == null) {
            return true;
        }

        if (node.data <= min) {
            return false;
        }

        if (node.data >= max) {
            return false;
        }

        boolean isLeftBST = this.isBST3(node.left, min, node.data);
        boolean isRightBST = this.isBST3(node.right, node.data, max);

        return isLeftBST && isRightBST;

    }

    public boolean isBalanced() {
        return this.isBalanced(this.root);
    }

    private boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }

        int lh = this.height(node.left);
        int rh = this.height(node.right);

        if (Math.abs(lh - rh) > 1) {
            return false;
        }

        boolean lr = this.isBalanced(node.left);
        boolean rr = this.isBalanced(node.right);

        return lr && rr;

    }

    public boolean isBalancedBtr() {
        return this.isBalancedBtr(this.root).isBalanced;
    }

    private BalancedPair isBalancedBtr(Node node) {

        if (node == null) {
            BalancedPair br = new BalancedPair();
            br.height = -1;
            br.isBalanced = true;
            return br;
        }


        BalancedPair lr = this.isBalancedBtr(node.left);
        BalancedPair rr = this.isBalancedBtr(node.right);

        BalancedPair mr = new BalancedPair();
        mr.isBalanced = true;

        mr.height = Math.max(lr.height, rr.height) + 1;

        if (Math.abs(lr.height - rr.height) > 1) {
            mr.isBalanced = false;
        }

        mr.isBalanced = lr.isBalanced && rr.isBalanced;

        return mr;
    }

    private class BalancedPair {
        boolean isBalanced;
        int height;
    }

    public void noSibling() {
        this.noSibling(this.root);
    }

    private void noSibling(Node node) {

        if (node.left != null && node.right == null) {
            System.out.println(node.left.data);
            noSibling(node.left);
        }

        if (node.right != null && node.left == null) {
            System.out.println(node.right.data);
            noSibling(node.right);
        }

        if (node.right != null && node.left != null) {
            noSibling(node.left);
            noSibling(node.right);
        }
    }

    public void removeLeaves() {
        this.removeLeaves(this.root);
    }

    private void removeLeaves(Node node) {

        if (node == null) {
            return;
        }

        if (node.left.left == null && node.left.right == null) {
            node.left = null;
        }

        if (node.right.left == null && node.right.right == null) {
            node.right = null;
        }

        this.removeLeaves(node.left);
        this.removeLeaves(node.right);

    }

    public void levelOrderLW() {
        LinkedList<Node> pQueue = new LinkedList<>();
        LinkedList<Node> cQueue = new LinkedList<>();


        pQueue.offer(this.root);

        while (!pQueue.isEmpty()) {

            Node node = pQueue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) {
                cQueue.offer(node.left);
            }

            if (node.right != null) {
                cQueue.offer(node.right);
            }

            if (pQueue.isEmpty()) {
                System.out.println();
                pQueue = cQueue;
                cQueue = new LinkedList<>();
            }

        }
    }

    public int lca(int num1, int num2) {
        return this.lca(num1, num2, this.root).data;
    }

    private Node lca(int num1, int num2, Node node) {

        if (node == null) {
            return null;
        }

        if (num1 == node.data || num2 == node.data) {
            return node;
        }

        Node lr = this.lca(num1, num2, node.left);
        Node rr = this.lca(num1, num2, node.right);

        if (lr != null && rr == null) {
            return lr;
        }

        if (rr != null && lr == null) {
            return rr;
        }

        if (lr != null && rr != null) {
            return node;
        }

        return null;

    }

    public void rootToLeaf(int k) {
        this.rootToLeaf(k, this.root, "");
    }

    private void rootToLeaf(int k, Node node, String ans) {

        if (node.left == null && node.right == null) {
            if (node.data == k) {
                System.out.println(ans + " " + node.data);
            }

            return;
        }

        if (node.left != null) {
            rootToLeaf(k - node.data, node.left, ans + " " + node.data);
        }
        if (node.right != null) {
            rootToLeaf(k - node.data, node.right, ans + " " + node.data);
        }
    }

    private void printKdown(Node node, int k) {

        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data + " ");
            return;
        }

        printKdown(node.left, k - 1);
        printKdown(node.right, k - 1);
    }

    private int printKfar(Node node, int k, int target) {

        if (node == null) {
            return -1;
        }

        if (node.data == target) {
            printKdown(node, k);
            return 0;
        }

        int dl = printKfar(node.left, k, target);

        if (dl != -1) {

            if (dl + 1 == k) {
                System.out.println(node.data + " ");
            } else {
                printKdown(node.right, k - (dl + 2));
            }
            return dl + 1;

        }
        int dr = printKfar(node.right, k, target);

        if (dr != -1) {

            if (dr + 1 == k) {
                System.out.println(node.data + " ");
            } else {
                printKdown(node.left, k - (dr + 2));
            }
            return dr + 1;
        }
        return -1;
    }

    public void printKfar(int target, int k) {
        printKfar(this.root, k, target);
    }
}

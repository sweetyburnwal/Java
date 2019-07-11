package lecture23;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by piyush0 on 22/07/17.
 */
public class Trie {

    private class Node {
        Character data;
        boolean isTerminal;
        HashMap<Character, Node> children;

        public Node(Character data, boolean isTerminal) {
            this.data = data;
            this.isTerminal = isTerminal;
            this.children = new HashMap<>();
        }
    }

    private Node root;
    private int numWords;

    public Trie() {
        this.root = new Node('\0', false);
    }

    public int getNumWords() {
        return this.numWords;
    }

    public boolean isEmpty() {
        return this.getNumWords() == 0;
    }

    public void addWord(String word) {
        this.addWord(word, this.root);
    }

    private void addWord(String word, Node node) {

        if (word.length() == 0) {

            if (!node.isTerminal) {
                node.isTerminal = true;
                this.numWords++;
            }

            return;
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        Node child = node.children.get(cc);

        if (child == null) {
            child = new Node(cc, false);
            node.children.put(cc, child);
        }

        this.addWord(ros, child);

    }

    public void displayWords() {
        this.displayWords(this.root, "");
    }

    private void displayWords(Node node, String ans) {

        // work
        if (node.isTerminal) {
            System.out.println(ans);
        }


        Collection<Node> children = node.children.values();

        for (Node child : children) {
            this.displayWords(child, ans + child.data);
        }

    }

    public boolean searchWord(String word) {
        return this.searchWord(word, this.root);
    }

    private boolean searchWord(String word, Node node) {

        if (word.length() == 0) {
            return node.isTerminal;
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        Node child = node.children.get(cc);

        if (child == null) {
            return false;
        }

        return this.searchWord(ros, child);

    }

    public void removeWord(String word) {
        this.removeWord(word, this.root);

    }

    private void removeWord(String word, Node node) {

        if (word.length() == 0) {
            if (node.isTerminal) {
                node.isTerminal = false;
                this.numWords--;
            }

            return;
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        Node child = node.children.get(cc);

        if (child == null) {
            return;
        }

        this.removeWord(ros, child);


        if (child.isTerminal) {
            return;
        }

        if (child.children.size() != 0) {
            return;
        }
        node.children.remove(cc);
    }

}

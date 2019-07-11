package lecture23;

import java.util.ArrayList;

/**
 * Created by piyush0 on 22/07/17.
 */
public class Client {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.addWord("art");
        trie.addWord("arts");
        trie.addWord("as");
        trie.addWord("see");
        trie.addWord("sea");
        trie.addWord("sell");
        trie.addWord("buy");
        trie.addWord("book");
        trie.addWord("bye");

        trie.displayWords();

        System.out.println(trie.searchWord("arts"));
        trie.removeWord("art");
        System.out.println(trie.searchWord("art"));
        System.out.println(trie.searchWord("arts"));
        System.out.println(trie.searchWord("as"));
    }
}
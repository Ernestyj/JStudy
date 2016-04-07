package leetcode201_210;

import java.util.HashMap;

/**Implement a trie with insert, search, and startsWith methods.
 Note: You may assume that all inputs are consist of lowercase letters a-z.
 * Created by eugene on 16/4/4.
 */
public class ImplementTriePrefixTree {

    //数据结构参考 http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode() {}
        public TrieNode(char c){
            this.c = c;
        }
    }

    // Your Trie object will be instantiated and called as such:
    // Trie trie = new Trie();
    // trie.insert("somestring");
    // trie.search("key");
    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            HashMap<Character, TrieNode> children = root.children;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                TrieNode t;
                if(children.containsKey(c)){
                    t = children.get(c);
                }else{
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                children = t.children;
                //set leaf node
                if(i==word.length()-1) t.isLeaf = true;
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode  t = searchNode(word);
            if (t!=null && t.isLeaf) return true;
            else return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(searchNode(prefix) == null) return false;
            else return true;
        }

        private TrieNode searchNode(String str){
            HashMap<Character, TrieNode> children = root.children;
            TrieNode t = null;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(children.containsKey(c)){
                    t = children.get(c);
                    children = t.children;
                }else{
                    return null;
                }
            }
            return t;
        }
    }

}

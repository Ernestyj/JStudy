package onlinealgo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugene on 16/4/20.
 */
public class WordListOrder {

    public static void main(String[] args) {
        String arr[] = {"abc","cde","efg","ghi"};
        System.out.println(canArrangeWords(arr));
    }


    static class WordNode{
        String word;
        int count;
        WordNode next, pre;
        char head, tail;
        WordNode(String word){
            this.word = word;
            head = word.charAt(0);
            tail = word.charAt(word.length()-1);
        }
    }
    public static int canArrangeWords(String arr[]) {
        ArrayList<WordNode> list = new ArrayList<>();
        HashMap<Character, WordNode> headMap = new HashMap<>();
        HashMap<Character, WordNode> tailMap = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            WordNode node = new WordNode(arr[i]);
            headMap.put(node.head, node);
            tailMap.put(node.tail, node);
            list.add(node);
        }
        for (int i=0; i<arr.length; i++) {
            WordNode node = list.get(i);
            if (headMap.containsKey(node.tail)) node.next = headMap.get(node.tail);
            if (tailMap.containsKey(node.head)) node.pre = tailMap.get(node.head);
        }
        WordNode head = null;
        for (int i=0; i<arr.length; i++) {
            if (list.get(i).pre==null) head = list.get(i);
        }
        int count = 0;
        while (head!=null){
            count++;
            head = head.next;
        }
        return count==arr.length? 1 : -1;
    }

}

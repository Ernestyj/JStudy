package leetcode131_140;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**A linked list is given such that each node contains an additional random pointer
 which could point to any node in the list or null. Return a deep copy of the list.
 * Created by eugene on 16/2/26.
 */
public class CopyListWithRandomPointer {

    //Definition for singly-linked list with a random pointer.
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    //仅使用哈希表和双指针,速度更快
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode p = head, q = newHead;
        p = p.next;
        while (p!=null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            q.next = newNode;
            q = newNode;
            p = p.next;
        }
        p = head; q = newHead;
        while (p!=null){
            if (p.random!=null) q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return newHead;
    }

    //与Clone Graph思路一致,使用队列和哈希表
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head==null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> queue = new LinkedList<>();
        queue.offer(head);
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        while (!queue.isEmpty()){
            RandomListNode curOld = queue.poll();
            RandomListNode[] olds = {curOld.next, curOld.random};
            for (int i=0; i<2; i++){
                if (olds[i]==null) continue;
                if (!map.containsKey(olds[i])){
                    RandomListNode newNode = new RandomListNode(olds[i].label);
                    map.put(olds[i], newNode);
                    if (i==0) map.get(curOld).next = newNode;
                    else map.get(curOld).random = newNode;
                    queue.offer(olds[i]);
                } else {
                    if (i==0) map.get(curOld).next = map.get(curOld.next);
                    else map.get(curOld).random = map.get(curOld.random);
                }
            }
        }
        return newHead;
    }

}

package leetcode81_90;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 * Created by DCLab on 1/3/2016.
 */
public class RemoveDuplicatesFromSortedListII {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 遍历中探测当前节点的下两个节点
     * http://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next!=null && p.next.next!=null){
            if(p.next.val==p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null && p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p = p.next;
            }
        }
        return dummy.next;
    }

}

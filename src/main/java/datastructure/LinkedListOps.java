package datastructure;

/**
 * Created by eugene on 16/3/2.
 */
public class LinkedListOps {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverse(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = null;
        return pre;
    }

    //链表l1/l2长度一致,交叉合并
    public void crossMerge(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p2!=null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }

}

package datastructure.linked;

/**
 * Created by eugene on 16/3/2.
 */
public class LinkedListOps {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //迭代
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
        head.next = null;   //TODO 易漏
        return pre;
    }
    //递归 TODO 稍难理解,速度比迭代慢
    public ListNode reverseRecursive(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode second = head.next;    //pin the second node
        head.next = null;   //TODO set first's next to be null
        ListNode rest = reverseRecursive(second);
        second.next = head;
        return rest;
    }
    /**TODO 这种方法更加难理解,注意last,pre,next指针不变,cur指针移动
     * 首先，搞清楚怎么逆转一个单链表。其实O(n)就可以了。
     * 第一个肯定是last one，然后我们每遍历到一个node，就把它放到最链表的首位，最后一个就成为第一个了。
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     * after call pre = reverse(pre, next)
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param pre
     * @param next
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    public ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;   //where first will be doomed "last"
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
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

package leetcode1_10;

/**（注意大整数）
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 *
 * Created by DCLab on 11/2/2015.
 */
public class AddTwoNumbers {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            if (l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            p = p.next; //TODO 易漏
            carry = carry/10;
        }
        if (carry!=0) p.next = new ListNode(carry); //TODO 易漏
        return dummy.next;
    }

}

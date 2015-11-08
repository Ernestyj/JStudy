package leetcode;

import java.util.*;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Created by DCLab on 11/6/2015.
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(5);
        l11.next = l12; l12.next = l13; l13.next = null;
//        ListNode l21 = new ListNode(2);
//        ListNode l22 = new ListNode(4);
//        ListNode l23 = new ListNode(9);
//        l21.next = l22; l22.next = l23; l23.next = null;
        ListNode l21 = null;
        ListNode[] lists = new ListNode[1];
//        lists[0] = l11;
        lists[0] = l21;

        ListNode node = new MergeKSortedLists().mergeKLists2(lists);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private List<Integer> array = null;
    private List<Integer> mergedArray = new ArrayList<>();
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode l : lists){
            if (l == null) continue;
            int i = 0;
            array  = new ArrayList<>();
            while (l != null){
                array.add(l.val);
                l = l.next;
            }
            mergedArray.addAll(array);
        }
        if (mergedArray.size() == 0) return null;
        Object[] result = mergedArray.toArray();
        Arrays.sort(result);
        ListNode head = new ListNode((Integer) result[0]);
        ListNode node = head;
        for (int i = 1; i < result.length; i++){
            node.next = new ListNode((Integer) result[i]);
            node = node.next;
        }
        node.next = null;
        return head;
    }

    //TODO 算法测试超时
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode node = null;
        for (int i = 0; i < lists.length; i++){
            node = mergeTwoLists(lists[i], node);
        }
        return node;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode mergedHead;
        ListNode mergedNode = null;
        if (l1 == null && l2 == null){  //TODO 易漏
            return null;
        } else if (l1 == null || (l2 != null && l1.val > l2.val)){  //TODO 易漏l2 != null
            mergedNode = l2;
            node2 = node2.next;
        } else if (l2 == null || (l1 != null && l1.val <= l2.val)) {    //TODO 易漏l1 != null，不过此处省略也没错
            mergedNode = l1;
            node1 = node1.next;
        }
        mergedHead = mergedNode;
        while (node2 != null){
            if (node1 == null || node1.val > node2.val){
                mergedNode.next = node2;
                node2 = node2.next;
            } else {
                mergedNode.next = node1;
                node1 = node1.next;
            }
            mergedNode = mergedNode.next;
        }
        while (node1 != null){
            mergedNode.next = node1;
            mergedNode = mergedNode.next;
            node1 = node1.next;
        }
        mergedNode.next = null;

        return mergedHead;
    }

}

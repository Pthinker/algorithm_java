24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        while(pre.next!=null && pre.next.next!=null) {
            ListNode t = pre.next.next;
            pre.next.next = t.next;
            t.next = pre.next;
            pre.next = t;
            pre = t.next;
        }
        return dummy.next;
    }
}

////////////////////////////////////////////////////////////////

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        } else {
            ListNode nextList = swapPairs(head.next.next);
            ListNode tmp = head.next;
            head.next = nextList;
            tmp.next = head;
            return tmp;
        }
    }
}

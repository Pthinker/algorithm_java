Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
        		cur.next = l1;
        		l1 = l1.next;
        	} else {
        		cur.next = l2;
        		l2 = l2.next;
        	}
        	cur = cur.next;
        }
        if (l1 != null) {
        	cur.next = l1;
        } else {
        	cur.next = l2;
        }
        return head.next;
    }
}
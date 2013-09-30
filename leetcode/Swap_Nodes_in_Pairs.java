Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values 
in the list, only nodes itself can be changed.


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
    	if(head==null || head.next==null)
    		return head;

		ListNode p1 = head.next;
		ListNode p2 = head;
		
		do {
			int tmp = p2.val;
			p2.val = p1.val;
			p1.val = tmp;
            if(p1.next==null || p1.next.next==null)
                break;
            else {
                p1 = p1.next.next;
                p2 = p2.next.next;
            }
		} while(true);

		return head;
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

Given a linked list, reverse the nodes of a linked list k at a time and 
return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end 
should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


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

// Iterative
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1)
            return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        int i = 0;
        while(head!=null) {
            i++;
            if(i%k==0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        
        return newHead.next;
    }
    
    public ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}

////////////////////////////////////////////////////////////////////////////////

// recursion
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) 
        	return head;
        
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            curr = curr.next;
            count++;
        }

        if(count < k)
        	return head;
        
        ListNode prev = null;
        curr = head;
        count = k;
        while(curr!=null && count>0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}


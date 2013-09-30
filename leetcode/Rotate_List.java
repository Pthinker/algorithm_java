Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null) 
            return head;

        int length = 1;
        ListNode p = head;
        while(p.next != null) {
        	length++;
        	p = p.next;
        }

        p.next = head;

        n = n % length;
        int step = length - n;

        p = head;
        while(step>1) {
        	p = p.next;
        	step--;
        }

        ListNode newHead = p.next;
        p.next = null;
    	return newHead;
    }
}

//////////////////////////////////////////////////////////////////////

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) 
            return null;
        
        ListNode n1 = head, n2 = head;
        while(n > 0) {
            n2 = n2.next;
            n--;
            if(n2 == null) {
                n2 = head;
            }
        }
        
        if(n1==n2) 
            return n1;
        
        while(n2.next != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        
        ListNode temp = n1.next;
        n2.next = head;
        n1.next = null;
        return temp;
    }
}

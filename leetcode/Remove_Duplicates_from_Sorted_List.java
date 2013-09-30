Given a sorted linked list, delete all duplicates such that each element 
appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        
        ListNode tail = head;
        ListNode pivot = head.next;
        
        while(pivot!=null) {
            if(pivot.val!=tail.val) {
                tail.next = pivot;
                tail = pivot;
            }
            
            pivot = pivot.next;
        }
        
        tail.next = null;
        return head;
    }
}

///////////////////////////////////////////////////////////////

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head==null)
            return null;
        
        ListNode n = head;
        while (n.next!=null) {
            if (n.next.val==n.val)
                n.next = n.next.next;
            else
                n = n.next;
        }
        
        return head;
        
    }
}

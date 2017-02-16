83. Remove Duplicates from Sorted List

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
        if(head==null) return null;
        
        ListNode cur = head;
        while(cur.next != null) {
            ListNode next = cur.next;
            if(next.val==cur.val) {
                cur.next = next.next;
                next.next = null;
            } else {
                cur = next;
            }
        }
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

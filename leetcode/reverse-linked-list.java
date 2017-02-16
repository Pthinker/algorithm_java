206. Reverse Linked List

Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


//Iterative
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
     
        ListNode p1 = head;
        ListNode p2 = p1.next;
     
        head.next = null;
        while(p1!=null&& p2!=null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
     
        return p1;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        ListNode next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

/////////////////////////////////////////////////////////////////////


// recursive
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
            return head;
     
        //get second node    
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;
     
        ListNode rest = reverseList(second);
        second.next = head;
     
        return rest;
    }
}

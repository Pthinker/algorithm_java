203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val) {
            head = head.next;
        }
        
        if(head==null) {
            return null;
        }
        
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null) {
            if(curr.val==val) {
                prev.next = curr.next;
            } else {
                prev=curr;
            }
            curr = curr.next;
        }
        
        return head;
    }
}

///////////////////////////////////////

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        ListNode cur = head;
        while(cur!=null) {
            if(cur.val != val) {
                prev.next = cur;
                prev = cur;
            } else {
                prev.next = cur.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}

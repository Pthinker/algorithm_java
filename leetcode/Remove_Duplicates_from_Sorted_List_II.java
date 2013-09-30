Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
        if(head==null || head.next==null)
            return head;
        
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        
        ListNode start = head;
        while(start!=null) {
            int count = 1;
            ListNode cur = start.next;
            while(cur!=null && cur.val==start.val) {
                cur = cur.next;
                count+=1;
            }
            if(count==1) {
                tail.next = start;
                tail = start;
            }
            start = cur;
        }
        tail.next = null;
        
        return newHead.next;
    }
}


////////////////////////////////////////////
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode newHead = null;
        ListNode tail = null;
        ListNode cur = head;
        ListNode begin = head;
        
        while (cur != null) {
            if (cur.next!=null && cur.next.val==begin.val) {
                cur = cur.next;
            } else {
                if (cur==begin) {
                    if (newHead==null) {
                        newHead = cur;
                        tail = newHead;
                    } else {
                        tail.next = cur;
                        tail = cur;
                    }
                }
                cur = cur.next;
                begin = cur;
            }
        }
        
        if (tail!=null)
            tail.next = null;
        
        return newHead;
    }
}

143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes'' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
分三步完成：（1）将链表切成两半，也就是找到中点，然后截成两条链表；（2）将后面一条链表进行reverse操作，就是反转过来；（3）将两条链表按顺序依次merge起来。
*/
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next==null) {  
            return;  
        }  
        ListNode slow = head;  
        ListNode fast = head;  
        while(fast.next!=null && fast.next.next!=null) {  
            slow = slow.next;  
            fast = fast.next.next;  
        }  
        ListNode head1 = head;  
        ListNode head2 = slow.next;  
        slow.next = null;  
        head2 = reverse(head2);  
        while(head1!=null && head2!=null) {  
            ListNode next = head2.next;  
            head2.next = head1.next;  
            head1.next = head2;  
            head1 = head2.next;  
            head2 = next;  
        }
    }
    
    private ListNode reverse(ListNode head) {  
        ListNode pre = null;  
        ListNode cur = head;  
        while(cur!=null) {  
            ListNode next = cur.next;  
            cur.next = pre;  
            pre = cur;  
            cur = next;  
        }  
        return pre;  
    }
}

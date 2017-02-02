61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) 
            return head;

        int length = 1;
        ListNode p = head;
        while(p.next != null) {
            length++;
            p = p.next;
        }

        p.next = head;

        k = k % length;
        int step = length - k;

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


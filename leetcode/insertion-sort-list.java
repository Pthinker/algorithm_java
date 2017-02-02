147. Insertion Sort List

Sort a linked list using insertion sort.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {  
        if(head == null||head.next == null)  
            return head;
        ListNode sortedlisthead = new ListNode(0);  
        ListNode cur = head;
        while(cur!=null) {  
            ListNode next = cur.next;  
            ListNode pre = sortedlisthead;  
            while(pre.next!=null && pre.next.val<cur.val)  
                pre = pre.next;  
            cur.next = pre.next;  
            pre.next = cur;  
            cur = next;  
        }  
        return sortedlisthead.next;  
    }
}

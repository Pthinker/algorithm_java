2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    
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

//mine
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int adv = 0;
        
        while(l1!=null || l2!=null) {
            int sum = adv;
            if(l1!=null) {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                sum+=l2.val;
                l2=l2.next;
            }
            adv = sum/10;
            prev.next = new ListNode(sum%10);
            prev = prev.next;
        }
        if(adv>0) {
            prev.next = new ListNode(adv);
        }
        return dummy.next;
    }
}

//////////////////////////////////////////////////////////////////////////////

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        int adv = 0;
        ListNode head = null;
        ListNode tail = null;
        
        while(l1!=null && l2!=null) {
            int sum = adv + l1.val + l2.val;
            int value = sum%10;
            adv = sum>=10 ? 1 : 0;
            if(head==null) {
                head = new ListNode(value);
                tail = head;
            } else {
                tail.next = new ListNode(value);
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode p = null;
        if(l1!=null) {
            p = l1;
        } else if(l2!=null) {
            p = l2;
        }
        while(p!=null) {
            int sum = adv + p.val;
            int value = sum % 10;
            adv = sum>=10 ? 1 : 0;
            tail.next = new ListNode(value);
            tail = tail.next;
            p = p.next;
        }
        
        if(adv>0)
            tail.next = new ListNode(adv);
        
        return head;
    }
}

//////////////////////////////////////////////////////////////////////////////

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int plus = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + plus;
            plus = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            if (plus != 0) {
                cur.next = addTwoNumbers(l1, new ListNode(plus));
            } else {
                cur.next = l1;
            }
        } else if (l2 != null) {
            if (plus != 0) {
                cur.next = addTwoNumbers(l2, new ListNode(plus));
            } else {
                cur.next = l2;
            }
        } else if (plus != 0) {
            cur.next = new ListNode(plus);
        }

        return head.next;
    }
}
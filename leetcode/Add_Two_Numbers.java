You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a 
single digit. Add the two numbers and return it as a linked list.

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

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p1 = l1;
        ListNode p2 = l2;
        int add = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(p1!=null && p2!=null) {
            int value = p1.val + p2.val + add;
        	if(value>9) {
        		add = 1;
        		value = value - 10;
        	} else {
        		add = 0;
        	}
        	ListNode node = new ListNode(value);
        	tail.next = node;
        	tail = node;
        	p1 = p1.next;
        	p2 = p2.next;
        }

        ListNode p = null;

        if(p1!=null) {
        	p = p1;
        } else if (p2!=null) {
        	p = p2;
        } 

        while(p!=null) {
        	int value = p.val + add;
        	if(value>9) {
        		add = 1;
       			value = value - 10;
       		} else {
        		add = 0;
       		}
       		ListNode node = new ListNode(value);
       		tail.next = node;
       		tail = node;
            p = p.next;
       	}

       	if(add>0) {
       		ListNode node = new ListNode(1);
       		tail.next = node;
       		tail = node;
       	}

        return head.next;
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
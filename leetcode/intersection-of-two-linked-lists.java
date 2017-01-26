160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.


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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; ++i) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; ++i) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return (headA != null && headB != null) ? headA : null;
    }
    
    public int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;
    }
}

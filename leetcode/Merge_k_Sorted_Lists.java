23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and 
describe its complexity.


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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (ListNode node : lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}

////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = null;
        for (ListNode node : lists)
            head = mergeTwoLists(head, node);
        return head;
    }
 
    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;
 
        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head2.next, head1);
            return head2;
        }
    }
}

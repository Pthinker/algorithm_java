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
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty())
            return null;

        Comparator<ListNode> comp = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                if (o1.val > o2.val)
                    return 1;
                return 0;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
                lists.size(), comp);

        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }

        ListNode head = null, cur = null;
        while (!heap.isEmpty()) {
            if (head == null) {
                head = heap.poll();
                cur = head;
            } else {
                cur.next = heap.poll();
                cur = cur.next;
            }
            if (cur.next != null)
                heap.add(cur.next);
        }
        
        return head;
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

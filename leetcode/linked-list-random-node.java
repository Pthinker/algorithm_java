382. Linked List Random Node

Given a singly linked list, return a random node value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int len=0;
    Random rand;
    ListNode ourHead;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        ourHead = head;
        ListNode curr = head;
        while(curr!=null) {
            len++;
            curr=curr.next;
        }
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int idx = rand.nextInt(len);
        ListNode curr = ourHead;
        while(idx>0){
            curr=curr.next;
            idx--;
        }
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

//////////////////////////////////////////////////////////////////

//follow up: reservoir sampling
public class Solution {
    ListNode head = null;
    Random randomGenerator = null;
    public Solution(ListNode head) {
        this.head = head;
        this.randomGenerator = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        
        for(int n = 1; current!=null; n++) {
            if (randomGenerator.nextInt(n) == 0) {
                result = current;
            }
            current = current.next;
        }
        
        return result.val;
    }
}

138. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        
        Map<RandomListNode, RandomListNode> randMap = new HashMap<RandomListNode, RandomListNode>();
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode prev = newHead;
        while(curr!=null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            prev.next=newNode;
            prev=newNode;
            randMap.put(curr, curr.random);
            nodeMap.put(curr, newNode);
            curr=curr.next;
        }
        for(RandomListNode node : nodeMap.keySet()) {
            nodeMap.get(node).random = nodeMap.get(randMap.get(node));
        }
        
        return newHead.next;
    }
}

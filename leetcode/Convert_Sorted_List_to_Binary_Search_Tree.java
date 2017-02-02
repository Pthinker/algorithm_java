109. Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode h = new ListNode(-1);
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
 
        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }
    
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;
 
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
    
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;
 
        // mid
        int mid = (start + end) / 2;
 
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);
 
        root.left = left;
        root.right = right;
 
        return root;
    }
}

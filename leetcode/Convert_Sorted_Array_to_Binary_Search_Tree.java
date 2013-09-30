Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sortedArrayToBST(num, 0, num.length-1);
    }
     
    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if(start > end)
        	return null;

        int mid = (start + end) / 2;
        TreeNode res = new TreeNode(num[mid]);
        res.left = sortedArrayToBST(num, start, mid - 1);
        res.right = sortedArrayToBST(num, mid + 1, end);
        return res;
    }
}

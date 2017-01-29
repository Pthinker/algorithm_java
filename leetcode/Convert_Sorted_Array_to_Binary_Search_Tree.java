108. Convert Sorted Array to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.


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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) {
            return null;
        }
        
        TreeNode n = helper(nums, 0, nums.length-1); 
        return n;
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if(left>right) {
            return null;
        }
        
        int mid = left + (right-left)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = helper(nums, left, mid-1);
        n.right = helper(nums, mid+1, right);
        
        return n;
    }
}
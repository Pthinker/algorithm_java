230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST''s total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursive
public class Solution {
    int count = 0;
    int result = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    
    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(root.right, k);       
    }
}

//////////////////////////////////////

//iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
         Stack<TreeNode> stack = new Stack<TreeNode>();
         TreeNode p = root;
         int count = 0;
         
         while(p!=null) {
             stack.push(p);
             p=p.left;
         }
         
         while(!stack.isEmpty()) {
             p=stack.pop();
             count++;
             if(count==k) {
                 return p.val;
             }
             if(p.right!=null) {
                 p=p.right;
                 while(p!=null) {
                     stack.push(p);
                     p=p.left;
                 }
             }
         }
         
         return Integer.MIN_VALUE;
    }
}
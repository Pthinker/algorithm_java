110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary 
tree in which the depth of the two subtrees of every node 
never differ by more than 1.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Exceed time limit
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh)>1)
        	return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {
    	if(node==null)
            return 0;
    	return 1 + Math.max(height(node.left), height(node.right));
    }
}

/////////////////////////////////////////////////////////////////////////////////
//优化后的方法为：对于每一个节点，我们递归获得左右子树的深度，如果子树是平衡的，则返回真实的深度，若不平衡，直接返回-1
public class Solution {
    public boolean isBalanced(TreeNode root) {
    	if(balanced(root)>=0)
    		return true;
    	else
    		return false;
    }	

    public int balanced(TreeNode node) {
    	if(node==null)
    		return 0;

        int l = balanced(node.left);
        if(l==-1)
            return -1;

    	int r = balanced(node.right);
    	if(r==-1)
    		return -1;
    	
    	if(Math.abs(l-r)>1)
    		return -1;
    	else
    		return 1 + Math.max(l, r);
    	
    }
}

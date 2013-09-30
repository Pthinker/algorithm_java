Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return false;

        if(root.left==null && root.right==null) {
            return sum==root.val;
        } else {
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        }
    }
}

////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
        	return false;

        if(root.left==null && root.right==null) {
        	if(sum-root.val==0)
        		return true;
        	else
        		return false;
        } else {
        	if(root.left==null) {
        		return hasPathSum(root.right, sum-root.val);
        	} else if(root.right==null) {
        		return hasPathSum(root.left, sum-root.val);
        	} else {
        		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        	}
        }
    }
}

	
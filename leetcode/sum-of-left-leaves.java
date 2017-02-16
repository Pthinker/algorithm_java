404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        return helper(root.left, true) + helper(root.right, false);
    }
    
    private int helper(TreeNode t, boolean left) {
        if(t==null) {
            return 0;
        }
        
        if(t.left==null && t.right==null) {
            if(left) {
                return t.val;
            } else {
                return 0;
            }
        } else {
            return helper(t.left, true) + helper(t.right, false);
        }
    }
}

//////////////

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int[] sum = new int[1];
        travel(root.left, sum, true);
        travel(root.right, sum, false);
        return sum[0];
    }
    
    private void travel(TreeNode node, int[] sum, boolean isLeft) {
        if(node==null) {
            return;
        }
        
        if(node.left==null && node.right==null && isLeft) {
            sum[0] += node.val;
            return;
        }
        
        travel(node.left, sum, true);
        travel(node.right, sum, false);
        return;
    }
}

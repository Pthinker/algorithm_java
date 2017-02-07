129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.


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
    public int sumNumbers(TreeNode root) {
        int[] res = new int[]{0};
        helper(root, res, 0);
        return res[0];
    }
    
    private void helper(TreeNode node, int[] res, int sum) {
        if(node==null) {
            return;
        }
        
        int currSum = sum*10+node.val;
        if(node.left==null && node.right==null) {
            res[0] += currSum;
            return;
        }
        
        helper(node.left, res, currSum);
        helper(node.right, res, currSum);
    }
}

//////////////////////////

public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode node, int sum) {
        if(node==null) {
            return 0;
        }
        
        int currSum = sum*10 + node.val;
        if(node.left==null && node.right==null) {
            return currSum;
        }
        
        return helper(node.left, currSum) + helper(node.right, currSum);
    }
}
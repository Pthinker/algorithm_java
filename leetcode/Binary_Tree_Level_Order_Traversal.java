102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) {
            return res;
        }
        
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(root);
        while(pre.size()>0) {
            List<Integer> row = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            for(TreeNode n : pre) {
                row.add(n.val);
                if(n.left!=null) next.add(n.left);
                if(n.right!=null) next.add(n.right);
            }
            res.add(row);
            pre=next;
        }
        
        return res;
    }
}

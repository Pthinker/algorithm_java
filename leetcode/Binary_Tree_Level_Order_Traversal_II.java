107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes
values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
   3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root==null)
            return res;
        
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        
        while(!cur.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> val = new ArrayList<Integer>();
            for(TreeNode n : cur) {
                val.add(n.val);
                if(n.left!=null)
                    next.add(n.left);
                if(n.right!=null)
                    next.add(n.right);
            }
            res.add(val);
            cur = next;
        }
        
        Collections.reverse(res);
        return res;
    }
}
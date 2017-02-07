199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].


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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) {
            return res;
        }
        
        List<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        while(prev.size()>0) {
            res.add(prev.get(prev.size()-1).val);
            List<TreeNode> next = new ArrayList<TreeNode>();
            for(TreeNode n : prev) {
                if(n.left!=null) next.add(n.left);
                if(n.right!=null) next.add(n.right);
            }
            prev=next;
        }
        
        return res;
    }
}

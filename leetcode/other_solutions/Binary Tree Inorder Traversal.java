Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
    	if (root == null) return inOrder;
    	Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        TreeNode p = root.left;
        while (!s.empty()) {
        	while (p != null) {
        		s.add(p);
        		p = p.left;
        	}
        	TreeNode n = s.pop();
        	inOrder.add(n.val);
        	p = n.right;
        	if (p != null) {
        		s.add(p);
        		p = p.left;
        	}
        }
        return inOrder;
    }
}
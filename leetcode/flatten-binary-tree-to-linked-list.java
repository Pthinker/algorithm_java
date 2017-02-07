114. Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


public class Solution {
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(stack.size()>0) {
            TreeNode n = stack.pop();
            if(n.right!=null) stack.push(n.right);
            if(n.left!=null) stack.push(n.left);
            n.left = null;
            n.right = stack.size()>0 ? stack.peek() : null;
        }
    }
}

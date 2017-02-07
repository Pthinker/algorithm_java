144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?


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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode curr = null;
        while(stack.size()>0) {
            curr = stack.pop();
            res.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }
        
        return res;
    }
}


/////////////////////////////////

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr!=null) {
            res.add(curr.val);
            stack.push(curr);
            curr=curr.left;
        }
        
        while(stack.size()>0) {
            curr = stack.pop().right;
            while(curr!=null) {
                res.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            }
        }
        
        return res;
    }
}

///////////////////////////////////////

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        visit(res, root);
        return res;
    }
    
    private void visit(List<Integer> res, TreeNode node) {
        if(node==null) {
            return;
        }
        res.add(node.val);
        visit(res, node.left);
        visit(res, node.right);
    }
}


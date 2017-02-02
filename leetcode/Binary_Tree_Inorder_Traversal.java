94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes values.

For example:
Given binary tree [1,null,2,3],
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


// recursive
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root, res);
        return res;
    }
    
    public void traverse(TreeNode node, ArrayList<Integer> res) {
        if(node!=null) {
            traverse(node.left, res);
            res.add(node.val);
            traverse(node.right, res);
        }
    }
}

/////////////////////////////////////////////////////////////////

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>();
        
        TreeNode node = root;
        while(node!=null) {
            sk.push(node);
            node = node.left;
        }
        
        while(!sk.empty()) {
            TreeNode n = sk.pop();
            res.add(n.val);
            n = n.right;
            while(n!=null) {
                sk.push(n);
                n = n.left;
            }
        }
        
        return res;
    }
}


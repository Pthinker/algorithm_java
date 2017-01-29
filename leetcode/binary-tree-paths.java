257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]



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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        helper(root, paths, "");
        return paths;
    }
    
    private void helper(TreeNode n, List<String> paths, String path) {
        if(n==null) {
            return;
        }
        
        path += n.val;
        if(n.left==null && n.right==null) {
            paths.add(path);
            return;
        }
        
        if(n.left!=null) {
            helper(n.left, paths, path+"->");
        }
        
        if(n.right!=null) {
            helper(n.right, paths, path+"->");
        }
    }
}

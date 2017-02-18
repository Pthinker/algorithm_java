513. Find Bottom Left Tree Value

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BFS
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int res = root.val;
        while(queue.size()>0) {
            int count = queue.size();
            boolean first = true;
            while(count>0) {
                TreeNode node = queue.poll();
                if(first) {
                    res = node.val;
                    first = false;
                }
                count--;
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}

/////////////////////////////////////

//DFS
public class Solution {
    int ans=0, h=0;
    public int findLeftMostNode(TreeNode root) {
        findLeftMostNode(root, 1);
        return ans;
    }
    public void findLeftMostNode(TreeNode root, int depth) {
        if (h<depth) {ans=root.val;h=depth;}
        if (root.left!=null) findLeftMostNode(root.left, depth+1);
        if (root.right!=null) findLeftMostNode(root.right, depth+1);
    }
}


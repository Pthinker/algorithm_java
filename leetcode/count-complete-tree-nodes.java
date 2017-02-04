222. Count Complete Tree Nodes

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


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
    public int countNodes(TreeNode root) {
        int hLeft = 0, hRight = 0;
        TreeNode pLeft = root, pRight = root;
        while(pLeft!=null) {
            ++hLeft;
            pLeft = pLeft.left;
        }
        while (pRight!=null) {
            ++hRight;
            pRight = pRight.right;
        }
        if (hLeft == hRight) 
            return (1<<hLeft) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

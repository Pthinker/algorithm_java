Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0 || 
        		preorder.length!=inorder.length)
            return null;
        
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int pl, int pr, 
    					  int[] inorder, int il, int ir) {
        if(pr < pl)
            return null;

        TreeNode root = new TreeNode(preorder[pl]);

        int index = 0;
        for(int i=il; i<=ir; i++) {
            if(inorder[i]==preorder[pl]) {
                index = i;
                break;
            }
        }

        root.left = build(preorder, pl+1, pl+index-il, inorder, il, index-1);
        root.right = build(preorder, pl+index-il+1, pr, inorder, index+1, ir);
        return root;
    }
}

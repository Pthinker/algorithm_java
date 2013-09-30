Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0 || 
        		inorder.length!=postorder.length)
            return null;
        
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int il, int ir, 
    					  int[] postorder, int pl, int pr) {
        if(ir < il)
            return null;
            
        TreeNode root = new TreeNode(postorder[pr]);
        
        int index = 0;
        for(int i=il; i<=ir; i++) {
            if(inorder[i]==postorder[pr]) {
                index = i;
                break;
            }
        }
        
        root.left = build(inorder, il, index-1, postorder, pl, pl+index-il-1);
        root.right = build(inorder, index+1, ir, postorder, pl+index-il, pr-1);
        return root;
    }
}

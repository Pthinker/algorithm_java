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


// recursive
public class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {   
        TreeNode prev = null;
        dfs(root);
    }
    
    public void dfs(TreeNode node) {
        if(node==null)
            return;
        
        TreeNode left = node.left;
        TreeNode right = node.right;
        
        if(prev!=null)
            prev.right = node;
        
        node.left = null;
        node.right = null;
    
        prev = node;
        
        dfs(left);
        dfs(right);
    }
}

/////////////////////////////////////////////////////////////////////////////

// Iterative
public class Solution {
    public void flatten(TreeNode root) {
        if(root==null) 
        	return;

        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        toVisit.push(root);

        TreeNode prev = null;
        while(!toVisit.isEmpty()) {
            TreeNode cur = toVisit.pop();
            if(cur.right!=null)
                toVisit.push(cur.right);
            if(cur.left!=null)
                toVisit.push(cur.left);
            if(prev!=null) {
                prev.left=null;
                prev.right = cur;
            }
            prev=cur;
        }
    }
}



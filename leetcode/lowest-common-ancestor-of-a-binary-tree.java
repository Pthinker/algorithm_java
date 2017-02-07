236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//https://www.youtube.com/watch?v=13m9ZCB8gjw
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) 
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left!=null && right!=null) {
            return root;
        } else {
            return left==null?right:left;
        }
    }
}

////////////////////////////////////////////////////////////////////////////////

//上述代码可以进行优化一下，在找完左子树的共同父节点时如果结果存在，且不是p或q，那么不用再找右子树了，直接返回这个结果即可，同理，对找完右子树的结果做同样处理
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) 
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left!=null && left!=p && left!=q) {
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(right!=null && right!=p && right!=q) {
            return right;
        }
        
        if(left!=null && right!=null) {
            return root;
        } else {
            return left==null?right:left;
        }
    }
}

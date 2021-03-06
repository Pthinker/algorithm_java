333. Largest BST Subtree

Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here is an example:

    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree''s size, which is 3.

 

Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?


//O(nlogn)
//The idea is pretty straight forward: we just recursively check if the subtree is valid BST or not, if it is, we just return the result. When we recursively check from the root, the first result returned would be the largest subtree.
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(helper(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return nodeCount(root);
        }
        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        return Math.max(left, right);
    }
    
    private int nodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
    
    private boolean helper(TreeNode root, long left, long right) {
        if(root == null) {
            return true;
        }
        if(root.val <= left || root.val >= right) {
            return false;
        }
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
}

////////////////////////////////////////

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        int[] ans = new int[]{0};
        findBST(root, ans);
        return ans[0];
    }
    
    private class Res {
        int min, max, size;
        
        public Res(int l, int r, int k) {
            min = l; max = r; size = k;
        }
    }
    
    private Res findBST(TreeNode rt, int[] ans) {
        if (rt == null) return null;
        boolean isBST = true;
        int min = rt.val, max = rt.val, size = 1;
        Res l = findBST(rt.left, ans), r = findBST(rt.right, ans);
        if (rt.left != null) {
            if (l == null || l.max > rt.val) return null;
            min = l.min;
            size += l.size;
        }
        if (rt.right != null) {
            if (r == null || r.min < rt.val) return null;
            max = r.max;
            size += r.size;
        }
        ans[0] = Math.max(ans[0], size);
        return new Res(min, max, size);
    }
}



230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST''s total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//In order travesal, need O(n) extra space
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<Integer>();
        travel(root, l);
        
        return l.get(k-1);
    }
    
    private void travel(TreeNode node, List<Integer> l) {
        if(node==null) {
            return;
        }
        
        travel(node.left, l);
        l.add(node.val);
        travel(node.right, l);
    }
}

//recursive
public class Solution {
    int count = 0;
    int result = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    
    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        traverse(root.right, k);       
    }
}

//////////////////////////////////////

//iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count= 0;
        TreeNode cur = root;
        while(cur!=null || !stack.empty()) {
            while(cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            count++;
            if(count==k) return cur.val;
            cur = cur.right;
        }
        return Integer.MIN_VALUE;
    }
}

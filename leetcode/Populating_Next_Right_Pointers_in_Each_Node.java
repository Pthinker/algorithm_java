Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is 
no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same 
	level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// Iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
            
        TreeLinkNode start = root;
  
        while(start.left!=null) {
            TreeLinkNode cur = start;
            while(cur!=null) {
                cur.left.next = cur.right;
                if(cur.next!=null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            start = start.left;
        }
    }
}

//////////////////////////////////////////////////////////////////////

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        
        if(root.left==null || root.right==null)
            return;
        
        TreeLinkNode rightSibling = null;
        TreeLinkNode p = root;
        while(p!=null) {
            if(p.next!=null) {
                rightSibling = p.next.left;
            } else {
                rightSibling = null;
            }
            p.left.next = p.right;
            p.right.next = rightSibling;
            p = p.next;
        }
        
        connect(root.left);
    }
}

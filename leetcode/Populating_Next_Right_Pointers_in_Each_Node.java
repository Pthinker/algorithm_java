116. Populating Next Right Pointers in Each Node

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
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


//mine
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        
        TreeLinkNode start = root;
        while(start.left!=null) {
            TreeLinkNode cur = start;
            while(cur!=null) {
                cur.left.next = cur.right;
                if(cur.next == null) {
                    cur.right.next = null;
                } else {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}

//////////////////////////////////////////////////////////////////////

// Iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode n = root;
        while(n!=null && n.left!=null) {
            TreeLinkNode rowNode = n;
            while(rowNode.next!=null) {
                rowNode.left.next = rowNode.right;
                rowNode.right.next = rowNode.next.left;
                rowNode = rowNode.next;
            }
            rowNode.left.next = rowNode.right;
            rowNode.right.next = null;
            
            n = n.left;
        }
    }
}


//////////////////////////////////////////////////////////////////////

//recursive
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) {
            return;
        }
        
        if (root.left!=null) {
            root.left.next = root.right;
        }
        if (root.right!=null) {
            root.right.next = (root.next!=null? root.next.left : null);
        }
        connect(root.left);
        connect(root.right);
    }
}




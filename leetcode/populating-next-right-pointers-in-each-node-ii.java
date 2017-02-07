117. Populating Next Right Pointers in Each Node II

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL


//recursive
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) {
            return;
        }
        TreeLinkNode p = root.next;
        while (p!=null) {
            if (p.left!=null) {
                p = p.left;
                break;
            }
            if (p.right!=null) {
                p = p.right;
                break;
            }
            p = p.next;
        }
        if (root.right!=null) root.right.next = p; 
        if (root.left!=null) root.left.next = (root.right!=null ? root.right : p); 
        connect(root.right);
        connect(root.left);
    }
}

/////////////////////////////////

//iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
    }
}

/////////////////////

//iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
    	    if (root.left != null) {
    		    pre.next = root.left;
    		    pre = pre.next;
    	    }
    	    if (root.right != null) {
    		    pre.next = root.right;
    		    pre = pre.next;
    	    }
    	    root = root.next;
    	    if (root == null) {
    		    pre = dummyHead;
    		    root = dummyHead.next;
    		    dummyHead.next = null;
    	    }
        }
    }
}

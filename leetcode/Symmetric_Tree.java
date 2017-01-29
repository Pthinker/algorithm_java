101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around 
    its center).

Note:
Bonus points if you could solve it both recursively and iteratively.


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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<String> inOrder = new ArrayList<String>();
        inOrder(root, inOrder);
        int start = 0, end = inOrder.size() - 1;
        while (start < end) {
            if (inOrder.get(start).equals(inOrder.get(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, ArrayList<String> inOrder) {
        if (root == null) {
            inOrder.add("#");
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val + "");
        inOrder(root.right, inOrder);
    }
}

/////////////////////////////////////////////////////////////////////////////

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) 
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode a, TreeNode b){
        if(a==null) 
            return b==null;
        if(b==null) 
            return false;
        
        if(a.val!=b.val) 
            return false;
        
        if(!isSymmetric(a.left, b.right)) 
            return false;
        if(!isSymmetric(a.right, b.left)) 
            return false;
        
        return true;
    }
}

/////////////////////////////////////////////////////////////////////////////

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) 
            return true;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>(),
                            r = new LinkedList<TreeNode>();
        l.add(root.left);
        r.add(root.right);
        while(!l.isEmpty() && !r.isEmpty()){
            TreeNode temp1 = l.poll(),
                     temp2 = r.poll();
            if((temp1==null && temp2!=null) || (temp1!=null && temp2==null))
                return false;
            if(temp1!=null) {
                if(temp1.val!=temp2.val) 
                    return false;
                l.add(temp1.left);
                l.add(temp1.right);
                r.add(temp2.right);
                r.add(temp2.left);
            }
        }
        return true;
    }
}

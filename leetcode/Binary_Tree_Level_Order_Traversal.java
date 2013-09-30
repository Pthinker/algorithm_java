Given a binary tree, return the level order traversal of its nodes 
values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},


    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(root==null)
            return res;
        
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        
        while(!cur.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> val = new ArrayList<Integer>();
            for(TreeNode n : cur) {
                val.add(n.val);
                if(n.left!=null)
                    next.add(n.left);
                if(n.right!=null)
                    next.add(n.right);
            }
            res.add(val);
            cur = next;
        }
        
        return res;
    }
}

///////////////////////////////////////////////////////////////////////////

public class Solution {
     public ArrayList<ArrayList> levelOrder(TreeNode root) {
        ArrayList<ArrayList> ret = new ArrayList<ArrayList>();
        
        if(root == null)
            return ret;
        
		    ArrayList<Integer> list = new ArrayList<Integer>();

        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
        LinkedList<TreeNode> other = new LinkedList<TreeNode>();
        cur.add(root);
        
        while(!cur.isEmpty()){
            TreeNode node = cur.remove();
            if(node.left != null)
                other.add(node.left);
            if(node.right != null)
                other.add(node.right);
            list.add(node.val);
            if(cur.isEmpty()){
                cur = other;
                other = new LinkedList<TreeNode>();
                ret.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return ret;
        
    }
}

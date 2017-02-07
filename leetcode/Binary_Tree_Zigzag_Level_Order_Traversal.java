103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) {
            return res;
        }
        
        List<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        boolean fromLeft = true;
        while(prev.size()>0) {
            List<Integer> row = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            for(TreeNode n : prev) {
                if(n.left!=null) next.add(n.left);
                if(n.right!=null) next.add(n.right);
            }
            int s=0, e=0;
            if(fromLeft) {
                for(int i=0; i<prev.size(); i++) {
                    TreeNode n = prev.get(i);
                    row.add(n.val);
                }
            } else {
                for(int i=prev.size()-1; i>=0; i--) {
                    TreeNode n = prev.get(i);
                    row.add(n.val);
                }
            }
            
            res.add(row);
            prev=next;
            fromLeft = !fromLeft;
        }
        
        return res;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) 
            return res;

        boolean order = true;
        ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
        toVisit.add(root);

        while(!toVisit.isEmpty()){
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(TreeNode node:toVisit){
                temp.add(node.val);
            }
            res.add(temp);

            for(int i=toVisit.size()-1; i>=0; i--) {
                TreeNode node = toVisit.get(i);
                if(order) {
                    if(node.right!=null) 
                        next.add(node.right);
                    if(node.left!=null) 
                        next.add(node.left);
                } else {
                    if(node.left!=null) 
                        next.add(node.left);
                    if(node.right!=null) 
                        next.add(node.right);
                }
            }
            order = order?false:true;
            toVisit = new ArrayList<TreeNode>(next);
        }
        return res;
    }
}
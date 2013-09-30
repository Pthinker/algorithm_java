Given a binary tree and a sum, find all root-to-leaf paths where each path sum 
equals the given sum.


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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            find(result, path, root, sum);
        }
        return result;
    }
    
    public void find(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, 
                     TreeNode node, int sum) {
        if(node.left==null && node.right==null) {
            if(sum==node.val) {
                ArrayList<Integer> clone = new ArrayList<Integer>(path);
                clone.add(node.val);
                result.add(clone);
            }
            return;
        } else {
            path.add(node.val);
            if(node.left!=null) 
                find(result, path, node.left, sum-node.val);

            if(node.right!=null) 
                find(result, path, node.right, sum-node.val);

            path.remove(path.size()-1);
        }
    }
}

Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.


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
    public int sumNumbers(TreeNode root) {
        if(root==null) 
            return 0;

        ArrayList<Integer> result = new ArrayList<Integer>();
        find(result, 0, root);
        int sum = 0;
        for(int i : result)
        	sum += i;
        return sum;
    }

    public void find(ArrayList<Integer> result, int value, TreeNode node) {
    	if(node.left==null && node.right==null) {
    		result.add(10 * value + node.val);
    	} else {
    		if(node.left!=null) 
    			find(result, value*10+node.val, node.left);
    		if(node.right!=null)
    			find(result, value*10+node.val, node.right);
    	}
    	return;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int sum){
        if(node == null) 
            return 0;

        int res = node.val + sum * 10;
        
        if(node.left==null && node.right==null) 
            return res;

        return dfs(node.left, res) + dfs(node.right, res);
    }
}


508. Most Frequent Subtree Sum

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.


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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(root==null) {
            return new int[0];
        }
        
        dfs(root, map);
        
        int max = Integer.MIN_VALUE;
        List<Integer> tmp = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue()==max) {
                tmp.add(entry.getKey());
            }
        }
        
        int[] res = new int[tmp.size()];
        int i=0;
        while(i<tmp.size()){
            res[i]=tmp.get(i);
            i++;
        }
        return res;
    }
    
    private int dfs(TreeNode node, Map<Integer, Integer> map) {
        if(node==null) {
            return 0;
        }
        
        int leftSum = dfs(node.left, map);
        int rightSum = dfs(node.right, map);
        int sum = leftSum + rightSum + node.val;
        map.put(sum, map.containsKey(sum)?map.get(sum)+1 : 1);
        
        return sum;
    }
}

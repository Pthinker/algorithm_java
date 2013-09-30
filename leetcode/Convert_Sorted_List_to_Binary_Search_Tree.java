Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length==0)
        	return null;

        return convert(num, 0, num.length-1);
    }

    public TreeNode convert(int[] num, int left, int right) {
    	if(left > right)
    		return null;

    	int middle = left + (right-left+1)/2;

    	TreeNode root = new TreeNode(num[middle]);
    	root.left = convert(num, left, middle-1);
    	root.right = convert(num, middle+1, right);

    	return root;
    }
}

/////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode left = sortedArrayToBST(num, start, mid - 1);
            TreeNode right = sortedArrayToBST(num, mid + 1, end);
            TreeNode node = new TreeNode(num[mid]);
            node.left = left;
            node.right = right;
            return node;
        }
        return null;
    }
}
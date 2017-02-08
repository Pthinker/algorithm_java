449. Serialize and Deserialize BST

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "*.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            sb.append("*.");
            return sb.toString();
        }
        sb.append(".");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] begin = {0};
        return deserializeMethod(data, begin);
    }
    
    private TreeNode deserializeMethod(String data, int[] begin) {
        int index = data.indexOf(".", begin[0]);
        TreeNode node = null;
        if (data.charAt(index - 1) == '*') {
            String str = data.substring(begin[0], index - 1);
            begin[0] = index + 1;
            if (str.equals("")) {
                return null;
            }
            node = new TreeNode(Integer.parseInt(str));
        } else {
            String str = data.substring(begin[0], index);
            begin[0] = index + 1;
            node = new TreeNode(Integer.parseInt(str));
            node.left = deserializeMethod(data, begin);
            node.right = deserializeMethod(data, begin);
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

255. Verify Preorder Sequence in Binary Search Tree 

Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?


//https://discuss.leetcode.com/topic/21217/java-o-n-and-o-1-extra-space
public boolean verifyPreorder(int[] preorder) {
    int low = Integer.MIN_VALUE;
    Stack<Integer> path = new Stack();
    for (int p : preorder) {
        if (p < low)
            return false;
        while (!path.empty() && p > path.peek())
            low = path.pop();
        path.push(p);
    }
    return true;
}

////////////////////////

https://discuss.leetcode.com/topic/26739/java-o-n-log-n-time-and-o-1-space-recursive-solution
public boolean verifyPreorder(int[] preorder) {
    return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private boolean verify(int[] preorder, int start, int end, int min, int max) {
    if (start > end) {
        return true;
    }
    int root = preorder[start];
    if (root > max || root < min) {
        return false;
    }
    
    int rightIndex = start;
    while (rightIndex <= end && preorder[rightIndex] <= root) {
        rightIndex++;
    }
    return verify(preorder, start + 1, rightIndex - 1, min, root) && verify(preorder, rightIndex, end, root, max);
}

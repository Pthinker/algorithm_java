370. Range Addition

Assume you have an array of length n initialized with all 0''s and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
Hint:

Thinking of using advanced data structures? You are thinking it too complicated.
For each update operation, do you really need to update all elements between i and j?
Update only the first and end element is sufficient.
The optimal time complexity is O(k + n) and uses O(1) extra space.


//思想是把所有需要相加的值存在第一个数，然后把这个范围的最后一位的下一位减去这个inc, 这样我所以这个范围在求最终值的时候，都可以加上这个inc，而后面的数就不会加上inc
public int[] getModifiedArray(int length, int[][] updates) {
    int[] result = new int[length];
    for (int i = 0; i < updates.length; i++) {
        int start = updates[i][0], end = updates[i][1];
        int inc = updates[i][2];
        result[start] += inc;
        if (end < length - 1) {
            result[end + 1] -= inc;
        }
    }
    
    int sum = 0;
    for (int i = 0; i < length; i++) {
        sum += result[i];
        result[i] = sum;
    }
    return result;
}

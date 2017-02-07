364. Nested List Weight Sum II

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1''s at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17) 



public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        sum(nestedList, res, 0);
        int total = 0;
        int w = res.size();
        for(Integer i : res){
            total += i * w--;
        }
        return total;
    }

    private void sum(List<NestedInteger> nestedList, List<Integer> list, int depth){

        while(depth >= list.size()){ 
            list.add(0);
        }

        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                list.set(depth, list.get(depth) + ni.getInteger());
            }else{
                sum(ni.getList(), list, depth+1);
            }
        }
    }
}

///////////////////

public int depthSumInverse(List<NestedInteger> nestedList) {
    int unweighted = 0, weighted = 0;
    while (!nestedList.isEmpty()) {
        List<NestedInteger> nextLevel = new ArrayList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                unweighted += ni.getInteger();
            else
                nextLevel.addAll(ni.getList());
        }
        weighted += unweighted;
        nestedList = nextLevel;
    }
    return weighted;
}

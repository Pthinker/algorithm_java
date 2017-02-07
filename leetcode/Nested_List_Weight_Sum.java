339. Nested List Weight Sum

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1''s at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)



//recursive
public int depthSum(List<NestedInteger> nestedList) {
    return helper(nestedList, 1);
}
 
public int helper(List<NestedInteger> nestedList, int depth){
    if(nestedList==null||nestedList.size()==0)
        return 0;
 
    int sum=0;
    for(NestedInteger ni: nestedList){
        if(ni.isInteger()){
            sum += ni.getInteger() * depth;
        }else{
            sum += helper(ni.getList(), depth+1);
        }
    }
 
    return sum;
}

///////////////////////////////////////////////

//iterative
public int depthSum(List<NestedInteger> nestedList) {
    int sum=0;
 
    LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
    LinkedList<Integer> depth = new LinkedList<Integer>();
 
    for(NestedInteger ni: nestedList){
        queue.offer(ni);
        depth.offer(1);
    }
 
    while(!queue.isEmpty()){
        NestedInteger top = queue.poll();
        int dep = depth.poll();
 
        if(top.isInteger()){
            sum += dep*top.getInteger();
        }else{
            for(NestedInteger ni: top.getList()){
                queue.offer(ni);
                depth.offer(dep+1);
            }
        }
    }
 
    return sum;
}
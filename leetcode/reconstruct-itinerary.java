332. Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.


public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> ret = new LinkedList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        Stack<String> stack = new Stack<String>();
        for(String[] t : tickets) {
            if(!map.containsKey(t[0])) 
                map.put(t[0], new PriorityQueue<String>());
            map.get(t[0]).offer(t[1]);
        }
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String next = stack.peek();
            if(map.containsKey(next) && map.get(next).size() > 0) 
                stack.push(map.get(next).poll());
            else 
                ret.addFirst(stack.pop());
        }
        return ret;
    }
}

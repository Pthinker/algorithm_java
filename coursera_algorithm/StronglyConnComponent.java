import java.util.HashMap;
import java.util.Stack;
import java.util.Map;


public class StronglyConnComponent {

    private static int finishTime = 0;

    /*
     * Reverse a directed graph
     */
    private static HashMap<Integer, HashMap<Integer, Integer>> reverse(
            HashMap<Integer, HashMap<Integer, Integer>> adjList) {
        HashMap<Integer, HashMap<Integer, Integer>> revAdjList = 
            new HashMap<Integer, HashMap<Integer, Integer>>();

        for (int source : adjList.keySet()) {
            for (int dest : adjList.get(source).keySet()) {
                if (revAdjList.containsKey(dest)) {
                    revAdjList.get(dest).put(source, 1);
                } else {
                    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                    tmp.put(source, 1);
                    revAdjList.put(dest, tmp);
                }

                if (!revAdjList.containsKey(source)) {
                    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                    revAdjList.put(source, tmp);
                }
            }
        }

        return revAdjList;
    }

    private static void DFS(HashMap<Integer, HashMap<Integer, Integer>> adjList, boolean[] isExplored, int start) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        isExplored[start] = true;
        
        while (!stack.empty()) {
            int current = stack.peek();
            boolean flag = false;
            for (int dest : adjList.get(current).keySet()) {
                if (!isExplored[dest]) {
                    flag = true;
                    stack.push(dest);
                    isExplored[dest] = true;
                    break;
                }
            }
            if (!flag)
                stack.pop();
        }
    }

    public static void DFS(HashMap<Integer, HashMap<Integer, Integer>> adjList) {
        boolean[] isExplored = new boolean[adjList.size() + 1]; //vertex number start from 1
        for (int i = 1; i < isExplored.length; i++)
            isExplored[i] = false;
        
        for (int i = 1; i<=adjList.size(); i++) {
            if (!isExplored[i]) {
                DFS(adjList, isExplored, i);
            }
        }
    }

    public static void SCC(HashMap<Integer, HashMap<Integer, Integer>> adjList) {
        boolean[] isExplored = new boolean[adjList.size() + 1]; //vertex number start from 1
        for (int i = 1; i < isExplored.length; i++)
            isExplored[i] = false;
        
        HashMap<Integer, Integer> finishMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> leaderMap = new HashMap<Integer, Integer>();

        // DFS on reverse graph to compute finish time
        HashMap<Integer, HashMap<Integer, Integer>> revAdjList = reverse(adjList);
        for (int i = adjList.size(); i > 0; i--) {
            if (!isExplored[i]) {
                DFS(revAdjList, isExplored, i, finishMap, leaderMap);
            }
        }

        Map<Integer, Integer> sorted = Utils.sortByValue(finishMap);
        //System.out.println(sorted.keySet());

        for (int i = 1; i < isExplored.length; i++)
            isExplored[i] = false;

        // DFS on original graph according to finish time in the first round of DFS
        for (int i : sorted.keySet()) {
            if (!isExplored[i]) {
                DFS(adjList, isExplored, i, finishMap, leaderMap);
            }
        }
        
        HashMap<Integer, Integer> leaderCount = new HashMap<Integer, Integer>();
        for (int i : leaderMap.keySet()) {
            int leader = leaderMap.get(i);
            if (leaderCount.containsKey(leader)) {
                leaderCount.put(leader, leaderCount.get(leader) + 1);
            } else {
                leaderCount.put(leader, 1);
            }
        }

        sorted = Utils.sortByValue(leaderCount);
        int i = 0;
        for (int key : sorted.keySet()) {
            System.out.println(sorted.get(key));
            i++;
            if (i==5) break;
        }
    }

    private static void DFS(HashMap<Integer, HashMap<Integer, Integer>> adjList, boolean[] isExplored, 
            int start, HashMap<Integer, Integer> finishMap, HashMap<Integer, Integer> leaderMap) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        isExplored[start] = true;
        leaderMap.put(start, start);
        
        while (!stack.empty()) {
            int current = stack.peek();
            boolean flag = false;
            for (int dest : adjList.get(current).keySet()) {
                if (!isExplored[dest]) {
                    flag = true;
                    stack.push(dest);
                    isExplored[dest] = true;
                    leaderMap.put(dest, start);
                    break;
                }
            }
            if (!flag) {
                int vertex = stack.pop();
                finishMap.put(vertex, ++finishTime);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, HashMap<Integer, Integer>> adjList = Utils.readDirectedGraph("data/SCC.txt");
        //HashMap<Integer, HashMap<Integer, Integer>> adjList = Utils.readDirectedGraph("data/dfs_test2.txt");
        
        SCC(adjList);
    }
}

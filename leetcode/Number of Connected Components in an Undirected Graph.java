323. Number of Connected Components in an Undirected Graph

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3

     |          |

     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4

     |           |

     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.


//dfs
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfsVisit(i, map, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        for (int j : map.get(i)) {
            if (visited.add(j))
                dfsVisit(j, map, visited);
        }
    }
}

////////////////////////////////////////////////////////

//union-find
private int[] father;
public int countComponents(int n, int[][] edges) {
    
    Set<Integer> set = new HashSet<Integer>();
    father = new int[n];
    for (int i = 0; i < n; i++) {
        father[i] = i;
    }
    for (int i = 0; i < edges.length; i++) {
         union(edges[i][0], edges[i][1]);
    }
    
    for (int i = 0; i < n; i++){ 
        set.add(find(i));
    }
    return set.size();
}

int find(int node) {
    if (father[node] == node) {
        return node;
    }
    father[node] = find(father[node]);
    return father[node];
}

void union(int node1, int node2) {
    father[find(node1)] = find(node2);
}

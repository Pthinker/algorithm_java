import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;


class Vertex implements Comparable<Vertex> {
    public int key;
    public ArrayList<Edge> edges;
    public double minDistance = Double.POSITIVE_INFINITY;

    public Vertex(int key) {
        this.key = key;
        edges = new ArrayList<Edge>();
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    public Vertex target;
    public double weight;
    
    public Edge(Vertex t, double w) {
        target = t; 
        weight = w;
    }
}

public class Dijkstra {
    public static void shortestPath(Vertex source) {
        source.minDistance = 0.0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            for (Edge e : u.edges) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Vertex> nodes = new HashMap<Integer, Vertex>();

        try {
            BufferedReader br =  new BufferedReader(new FileReader("data/DijkstraData.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\t");
                Vertex v;
                int key = Integer.parseInt(arr[0]);
                if (nodes.containsKey(key)) {
                    v = nodes.get(key);
                } else {
                    v = new Vertex(key);
                    nodes.put(key, v);
                }

                for (int i = 1; i < arr.length; i++) {
                    String[] tmp = arr[i].split(",");
                    key = Integer.parseInt(tmp[0]);
                    Vertex ve;
                    if (nodes.containsKey(key)) {
                        ve = nodes.get(key);
                    } else {
                        ve = new Vertex(key);
                        nodes.put(key, ve);
                    }

                    Edge edge = new Edge(ve, Double.parseDouble(tmp[1]));
                    v.edges.add(edge);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Find shortest path from node 1 to other nodes
        shortestPath(nodes.get(1));
    }
}


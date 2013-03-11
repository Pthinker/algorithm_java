import java.util.Random;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.io.*;
import java.util.*;


class Utils {
    /*
     * Read file of graph for Dijkstra algorithm, see example in data/DijkstraData.txt
     */
    public static HashMap<Integer, HashMap<Integer, Integer>> readDijkstraGraph(String fpath) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = 
            new HashMap<Integer, HashMap<Integer, Integer>>();
        try {
            BufferedReader br =  new BufferedReader(new FileReader(fpath));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\t");
                HashMap<Integer, Integer> adj = new HashMap<Integer, Integer>();
                for (int i = 1; i < arr.length; i++) {
                    String[] tmp = arr[i].split(",");
                    adj.put(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
                }
                graph.put(Integer.parseInt(arr[0]), adj);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return graph;
    }

    /*
     * Read a directed graph from fpath, each row represents a arch using two 
     * columns. The first is the source vertext and the second end vertex.
     * Return: Adjencency list of a hash map
     */
    public static HashMap<Integer, HashMap<Integer, Integer>> readDirectedGraph(String fpath) {
        HashMap<Integer, HashMap<Integer, Integer>> adjList = 
            new HashMap<Integer, HashMap<Integer, Integer>>();

        try {
            BufferedReader br =  new BufferedReader(new FileReader(fpath));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                int source = Integer.parseInt(arr[0]);
                int dest = Integer.parseInt(arr[1]);
                
                if (adjList.containsKey(source)) {
                    adjList.get(source).put(dest, 1);
                } else {
                    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                    tmp.put(dest, 1);
                    adjList.put(source, tmp);
                }
                
                if (!adjList.containsKey(dest)) {
                    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                    adjList.put(dest, tmp);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return adjList;
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<K, V> sortedMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry: entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


    /*
     * Generate a random integer array with the size defined by length
     * Return: an integer array
     */
    public static int[] generateArray(int length) {
        Random rand = new Random();
        int[] iarr = new int[length];
        int i;

        for(i=0; i<length; i++) {
            int randNum = rand.nextInt();
            iarr[i] = randNum;
        }
        return iarr;
    }

    /*
     * Generate a random integer array with the size defined by length
     * Return: an integer array that every element is less than limit
     */
    public static int[] generateArray(int length, int limit) {
        Random rand = new Random();
        int[] iarr = new int[length];
        int i;

        for(i=0; i<length; i++) {
            int randNum = rand.nextInt(limit);
            iarr[i] = randNum;
        }
        return iarr;
    }

    /*
     * Output an integer array
     */
    public static void printArray(int[] arr) {
        for(int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
     * Read a list of integers from filePath, each integer is in one line
     * Return an integer array
     */
    public static int[] readIntArrayFromFile(String filePath) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        try {
            BufferedReader input =  new BufferedReader(new FileReader(filePath));
            String line = null;
            while( (line=input.readLine()) != null ) {
                numList.add(new Integer(line));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        int[] numArr = new int[numList.size()];
        Iterator<Integer> iterator = numList.iterator();
        for(int i=0; i<numList.size(); i++) {
            numArr[i] = iterator.next().intValue();
        }

        return numArr;
    }

    public static void main(String[] args) {
        int[] arr = generateArray(100);
        printArray(arr);
    }
}

126. Word Ladder II

Given two words (beginWord and endWord), and a dictionary''s word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

//http://www.cnblogs.com/grandyang/p/4579693.html

public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            int duplicate = 1, vertical = 0;
            Map<Double, Integer> m = new HashMap<>();
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    ++duplicate;
                } else if (points[i].x == points[j].x) {
                    m.put(Double.MAX_VALUE, m.getOrDefault(Double.MAX_VALUE, 0) + 1);
                } else if (points[i].y == points[j].y) {
                    m.put(0.0, m.getOrDefault(0.0, 0) + 1);
                } else {
                    double slope = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
                    m.put(slope, m.getOrDefault(slope, 0) + 1);
                }
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Double, Integer> e : m.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }
}

//////////////////////////////

public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Map<Integer, Integer>, Integer> m = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    ++duplicate; continue;
                }
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }
    
    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}

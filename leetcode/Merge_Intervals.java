56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval a, Interval b) {
               return a.start-b.start;
           } 
        });
        
        List<Interval> res = new ArrayList<Interval>();
        int i=0;
        while(i<intervals.size()) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int j=i+1;
            while(j<intervals.size() && intervals.get(j).start<=end) {
                end = Math.max(end, intervals.get(j).end);
                j++;
            }
            res.add(new Interval(start, end));
            i = j;
        }
        return res;
    }
}
352. Data Stream as Disjoint Intervals

Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream''s size?


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    List<Interval> summary;
    public SummaryRanges() {
        summary = new ArrayList<>();
    }
    
    public void addNum(int val) {
        Interval cur = new Interval(val, val);
        List<Interval> rst = new ArrayList<Interval>();
        int pos = 0;
        for(Interval interval : summary){
            //non Overlap
            if(cur.end + 1 < interval.start) {
                rst.add(interval);
                continue;
            }
            if(cur.start > interval.end + 1){
                rst.add(interval);
                pos++;
                continue;
            }
            //Overlap
            if(cur.start - 1 == interval.end) {
                cur.start = interval.start;
            } else if(cur.end + 1 == interval.start) {
                cur.end = interval.end;
            } else {
                //merge
                cur.start = Math.min(cur.start, interval.start);
                cur.end = Math.max(cur.end, interval.end);
            }
        }
        rst.add(pos, cur);
        summary = new ArrayList<Interval>(rst);
    }
    
    public List<Interval> getIntervals() {
        return summary;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

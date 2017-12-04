/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
          return result;
        }

        // O(nlogn)
        Collections.sort(intervals, new Comparator<Interval>() {
          @Override
          public int compare(Interval interval1, Interval interval2) {
            return interval1.start - interval2.start;
          }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        // O(n), O(n)
        for (int i = 1; i < intervals.size(); i++)
        {
          Interval interval = intervals.get(i);

          if (interval.start <= end) {
            end = Math.max(end, interval.end);
          } else {
            result.add(new Interval(start, end));

            start = interval.start;
            end = interval.end;
          }
        }

        result.add(new Interval(start, end));

        return result;
    }
}
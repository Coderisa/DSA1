import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval overlaps with the previous, remove it
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                // Otherwise, update the end time
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}

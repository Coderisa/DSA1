import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // TreeMap to store start -> index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        // For each interval, find the right interval
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}

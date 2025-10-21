import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort courses by their lastDay
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Max heap to track durations of selected courses
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            time += duration;
            maxHeap.offer(duration);

            // If total time exceeds the deadline, remove the longest course
            if (time > lastDay) {
                time -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}

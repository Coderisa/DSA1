import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        // directions: up, left, right, down
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        // result matrix stores the minimum effort (max diff) to reach each cell
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        
        // min-heap: stores int[]{effort, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        result[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            // If we reached the destination, return effort
            // Because the heap gives the smallest effort first
            if (x == m-1 && y == n-1) {
                return effort;
            }
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newEffort < result[nx][ny]) {
                        result[nx][ny] = newEffort;
                        pq.offer(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }
        
        return result[m-1][n-1]; // fallback, should never reach here if path exists
    }
}
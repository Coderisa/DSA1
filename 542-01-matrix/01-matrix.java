import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize result matrix and queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Step 2: BFS from all 0s
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : dirs) {
                int r = row + dir[0], c = col + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && result[r][c] > result[row][col] + 1) {
                    result[r][c] = result[row][col] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return result;
    }
}

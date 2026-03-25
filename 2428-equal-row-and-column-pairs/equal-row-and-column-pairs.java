import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        Map<List<Integer>, Integer> map = new HashMap<>();

        // Step 1: Store each row in the map
        for (int r = 0; r < n; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                row.add(grid[r][c]);
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        // Step 2: Build each column and check against map
        for (int c = 0; c < n; c++) {
            List<Integer> col = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                col.add(grid[r][c]);
            }
            count += map.getOrDefault(col, 0);
        }

        return count;
    }
}

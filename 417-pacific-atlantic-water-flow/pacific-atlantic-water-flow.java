class Solution {
    private int m, n;
    private int[][] heights;
    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Start DFS from Pacific Ocean borders
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights[i][0]);       // Left edge
            dfs(i, n - 1, atlantic, heights[i][n - 1]); // Right edge
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights[0][j]);       // Top edge
            dfs(m - 1, j, atlantic, heights[m - 1][j]); // Bottom edge
        }
        
        // Collect cells reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        visited[r][c] = true;
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], visited, heights[r][c]);
        }
    }
}

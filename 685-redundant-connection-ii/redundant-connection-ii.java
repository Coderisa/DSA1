class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] root = new int[n + 1];
        int[] edge1 = null, edge2 = null;

        // Step 1: Detect if a node has two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                edge1 = new int[]{parent[v], v}; // earlier edge
                edge2 = new int[]{u, v};         // later edge
                edge[1] = 0; // mark edge2 as invalid temporarily
            }
        }

        // Step 2: Union-Find to detect cycle
        for (int i = 1; i <= n; i++) root[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue; // skip invalid edge

            int pu = find(root, u);
            if (pu == v) {
                // Cycle detected
                return edge1 != null ? edge1 : edge;
            }
            root[v] = pu;
        }

        // No cycle, but a node had two parents
        return edge2;
    }

    private int find(int[] root, int x) {
        if (root[x] != x) {
            root[x] = find(root, root[x]);
        }
        return root[x];
    }
}

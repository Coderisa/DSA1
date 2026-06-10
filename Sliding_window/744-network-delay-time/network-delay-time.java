class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // adjacency list: index 0 unused, 1..n
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : times) {
            int a = e[0], b = e[1], w = e[2];
            adj.get(a).add(new int[]{b, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // min-heap ordered by distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            if (d > dist[u]) continue; // stale entry

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                int nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
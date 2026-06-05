class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int i[] : prerequisites) {
            int c = i[0];
            int p = i[1];
            adj.get(p).add(c);
            inDegree[c]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        int ans[] = new int[numCourses];
        int c = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            ans[c] = u;
            c++;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
            }
        }
        if(c!= numCourses) return new int[0];
        else
        return ans;

    }
}
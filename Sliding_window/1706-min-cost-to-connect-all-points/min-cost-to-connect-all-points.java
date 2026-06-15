class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0;i< points.length;i++)
          adj.add(new ArrayList<>());

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length; j++){
                int dist=Math.abs(points[i][0]- points[j][0])+Math.abs(points[i][1] -points[j][1]);
                adj.get(i).add(new int[]{j, dist});//wt,node
                adj.get(j).add(new int[]{i, dist});
            }
        }
        int ans=0;
        int vis[]=new int[points.length];//1 baar jo node ho gayi hai usko fir se traverse nhi karna hai 
PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});//wt,node
        while(!pq.isEmpty()){
            int t[]=pq.poll();
            int wt=t[0];
            int n= t[1];

            if(vis[n]==1)continue;
            vis[n]=1; ans+=wt;
            for(int e[]:adj.get(n)){
                int new_n=e[0], new_wt=e[1];
        if(vis[new_n]==0) pq.offer(new int[]{new_wt,new_n});

            }
        }
        return ans;

    }
}
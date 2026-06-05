/*
class Solution {
    public int findCircleNum(int[][] isConnected) {
         ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        int r=isConnected.length;int V =r; 
        int c=isConnected[0].length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i!=j){
                    if(isConnected[i][j]==1) 
                      adj.get(i).add(j);
                }
            }
        }
        
      
       
        boolean vis[]=new boolean[V];
        int co=0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
               dfs(adj,vis,i);
               co++;
            }
        }
        return co;
    }
    private void dfs(  ArrayList<ArrayList<Integer>>adj,boolean vis[],int u){
       vis[u]=true;
       for(int v:adj.get(u)){
           if(!vis[v])
              dfs(adj,vis,v);
       }
    }
}*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
         ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        int r=isConnected.length;int V =r; 
        int c=isConnected[0].length;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i!=j){
                    if(isConnected[i][j]==1) 
                      adj.get(i).add(j);
                }
            }
        }
        
      
       
        boolean vis[]=new boolean[V];
        int co=0;
        

        for(int i=0;i<V;i++){
            if(!vis[i]){
               bfs(adj,vis,i);
               co++;
            }
        }
        return co;
    }
    private void bfs(  ArrayList<ArrayList<Integer>>adj,boolean vis[],int u){
      Queue<Integer>q=new LinkedList<>();
        q.offer(u);
       vis[u]=true;

          while(!q.isEmpty()){
           int n=q.poll();
             for(int v:adj.get(n)){
           if(!vis[v]) {
                q.add(v);
                vis[v]=true; }
            
       }
    }
}
}

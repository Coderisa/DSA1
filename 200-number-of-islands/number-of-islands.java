 /*
 class Solution {
    int row,col;
    
    public int numIslands(char[][] grid) {
         row=grid.length; col=grid[0].length;
        boolean vis[][]=new boolean[row][col];//false

     int  count=0;
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]!='0' && !vis[i][j]){
             dfs(i,j,grid,vis);
             count++;
            }   
        }
       }
       return count;
    }

 void dfs(int r,int c,char[][]grid,boolean vis[][]){

            if(r<0||r>=row||c<0||c>=col||vis[r][c]==true||grid[r][c]=='0')
            return ;
          
            vis[r][c]=true;  
            int adjList[][]={{r-1,c},{r,c-1},{r+1,c},{r,c+1}};
            for(int neighbour[]: adjList){
                dfs(neighbour[0],neighbour[1],grid,vis);
            }
            
        }//dfs

}*/
class Solution {
    int row,col;
    
    public int numIslands(char[][] grid) {
         row=grid.length; col=grid[0].length;
        boolean vis[][]=new boolean[row][col];//false

     int  count=0;
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]!='0' && !vis[i][j]){
             bfs(i,j,grid,vis);
             count++;
            }   
        }
       }
       return count;
    }
    void bfs(int r, int c, char[][] grid, boolean vis[][]){
        Queue<int []>q=new LinkedList<>();
        q.add(new int[]{r,c});
        vis[r][c]=true;

        while(!q.isEmpty()){
            int node[]=q.poll();
            int rows=node[0];int cols=node[1];
            int adjList[][]={{rows-1,cols},{rows+1,cols},{rows,cols+1},{rows,cols-1}};
            //adding neighbours to queue

            for(int neighbours[]:adjList){
                int rr=neighbours[0]; int cc=neighbours[1];

                if(rr<0||rr>=row|| cc<0 ||cc>=col||vis[rr][cc]==true||grid[rr][cc]=='0')
                continue;

                q.offer(new int[]{rr,cc});
                vis[rr][cc]=true;
                
            }

        }

    }
}//class
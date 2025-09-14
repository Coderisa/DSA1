class Solution {
    int row,col;
    
    public int numIslands(char[][] grid) {
         row=grid.length; col=grid[0].length;
        boolean vis[][]=new boolean[row][col];//false

     int flag=0, count=0;
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]!=0){
             int b=dfs(i,j,grid,vis,flag);
             if(b==1)
             count++;
             flag=0;
            }
              
        }
       }
       return count;

    }

 int  dfs(int r,int c,char[][]grid,boolean vis[][],int flag){

            if(r<0||r>=row||c<0||c>=col||vis[r][c]==true||grid[r][c]=='0')
            return 0;

            vis[r][c]=true;
            flag=1;
            int adjList[][]={{r-1,c},{r,c-1},{r+1,c},{r,c+1}};
            for(int neighbour[]: adjList){
                dfs(neighbour[0],neighbour[1],grid,vis,flag);
            }
            return flag;
        }//dfs

}
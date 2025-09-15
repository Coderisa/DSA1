class Solution {
    
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int freshCount=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) freshCount++;
                else if(grid[i][j]==2)
                q.offer(new int[]{i,j});//storing rotten oranges presnt in grid
            }
        }
        if(freshCount==0) return 0;
        int time=0;

        while(!q.isEmpty()){
            int size=q.size();//current level mein rooting oranges
            //level by level
            for(int i=0;i<size;i++){
                int rottenLoc[]= q.poll();
                int r=rottenLoc[0];
                int c=rottenLoc[1];
                int neighbours[][]={
                    {r-1,c},{r,c-1},{r+1,c},{r,c+1}
                };
                for(int neighbour[]: neighbours){
                    int nr=neighbour[0];
                    int nc=neighbour[1];
                    //out bound /rotten -visited
                    if(nr<0|| nr>=n||nc<0||nc>=m|| grid[nr][nc] != 1)
                        continue;//go to next iteration
                    
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc]=2;//marked as visited
                    
                }
               
            }
             time++;
            freshCount-=q.size();
            if(freshCount==0)
            break;//no more rotten oranges
           
        }//while
                
            
            return freshCount == 0 ? time : -1;
        }
        }
        
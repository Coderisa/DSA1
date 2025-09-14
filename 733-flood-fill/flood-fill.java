/* DFS 
class Solution {
    int rows,cols;//instance variable can be acced throuhout the class
    void dfs(int row, int col,int newColor, int curColor, int image[][]){
        //out of boud cases, visited & color not same
        if(row< 0 || row>=rows||col<0|| col>=cols|| image[row][col]!=curColor|| image[row][col]==newColor){
            return;
        }
        image[row][col]= newColor;
        //visit neighbours :[up, down, right, left]
        int adjList[][]={{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int neighbour[]:adjList){
            dfs(neighbour[0],neighbour[1],newColor,curColor, image);
        }
    }
    
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows=image.length;
        cols=image[0].length;
        dfs(sr,sc,color,image[sr][sc],image);
        return image;
    }
}*/
//BFS -----------
class Solution{
    int rows;
    int cols;
public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows=image.length;
        cols=image[0].length;
        int curColor=image[sr][sc];
        Queue<int[]> q=new LinkedList<>();//Queue<String> queue = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc]=color;//fill/ visited


        while(!q.isEmpty()){
            int node[]=q.poll();//current index in queue
            int row=node[0];
            int col=node[1];

            //next node to be visited
            int adjList[][]={{row-1,col},{row,col+1},{row+1,col},{row,col-1}};

            //adding neighbours to queue
        for(int neighbour[]:adjList){
              int r=neighbour[0];
              int c=neighbour[1];
            if(r< 0 || r>=rows||c<0|| c>=cols|| image[r][c]!=curColor|| image[r][c]==color)
            continue;//q out of bound hence skip

            q.offer(new int[]{r,c});
            image[r][c]=color;//add neighbour to queue and mark it visited
        }//for

        }
        return image;
    }
        }//class
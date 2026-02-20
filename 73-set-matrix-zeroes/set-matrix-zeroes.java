public class Solution {
public void setZeroes(int[][] matrix) {
    int r[][]=new int[matrix.length][matrix[0].length];
     for(int i=0;i<matrix.length;i++)
    {
        for(int j=0;j<matrix[0].length;j++)
        {
            if (matrix[i][j] == 0)
              r[i][j]=1;
            else 
                r[i][j]=0;
        }
    }
    for(int i=0;i<matrix.length;i++)
    {
        for(int j=0;j<matrix[0].length;j++)
        {
            int a=matrix[i][j];
            if(a==0 && r[i][j]==1 )
            {
                for(int d=0;d<matrix[0].length;d++)
                matrix[i][d]=0;

                for(int e=0;e<matrix.length;e++)
                matrix[e][j]=0;
            }
           
    
        }
    }
}
}
//In computer science, an in-place algorithm is an algorithm that operates directly on the input data structure without requiring extra space proportional to the input size. In other words, it modifies the input in place, without creating a separate copy of the data structure. An algorithm which is not in-place is sometimes called not-in-place or out-of-place.
/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=matrix[0].length-1;

        while(i<matrix.length ){
            if (target==matrix[i][j])
             return true;
              if (target<matrix[i][j]){
                int b=0,e=j;
                while(b<=e){
                    int mid=b+(e-b)/2;
                    if(target==matrix[i][mid])
                    return true;
                    else if(target>matrix[i][mid])
                    b=mid+1;
                    else 
                    e=mid-1;
                }
              }
                i++;
             }
             return false;
            }
        } */
        //t-O(log(m*n))
        class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int start=0,end=m*n-1;
        while(start<=end){
            int mid=start+ (end-start)/2;
            int row=mid/n;
            int col=mid%n;

            if(matrix[row][col] > target)
                end = mid-1;
            else if(matrix[row][col]<target)
                start = mid+1;
               else 
                  return true; 
              }
        
              return false;  
            
        }
        }

    

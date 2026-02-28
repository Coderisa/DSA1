/*
 Company Tags                : Accolite, MentorGraphics, Adobe, Amazon, Directi, Goldman Sachs, Groupon,
                                  InMobi, MakeMyTrip, Ola Cabs, One97, Oracle, Paytm, Polycom,
                                  SAP Labs, Snapdeal, TinyOwl, Visa, Microsoft
//Approach-1 O(m*n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
*/


        //t-O(log(m*n))
        class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int start=0, end=m*n-1;
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

    

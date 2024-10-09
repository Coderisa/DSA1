//Transpose of a matrix
/*
00 01 02 03          00  10  20  
10 11 12 13          01  11  12
20 21 22 23          02  21  22
                     03  31  32
Just interchange row and column
*/ 

import java.util.Scanner;
class xyz
  {
    public static void main(String args[])
    {
      Scanner sc=new Scanner (System.in);
      
        System.out.println("Enter the row and column size ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int arr[][]=new int [r][c];//Array declaration
         int tarr[][]=new int [c][r];
        System.out.println("Enetr the values for 2 -D array");
        for(int i=0;i<r;i++)
          {
            for(int j=0;j<c ;j++)
              {
                arr[i][j]=sc.nextInt();
                System.out.print(arr[i][j]+" ");
              }System.out.println();
          }
        //Transpose
       for(int i=0;i<r;i++)
          {
            for(int j=0;j<c ;j++)
              {
                tarr[j][i]=arr[i][j];
              }
          }
        //printing transpose of array
         for(int i=0;i<r;i++)
          {
            for(int j=0;j<c ;j++)
              {
                
                System.out.print(tarr[i][j] +" ");
              }System.out.println();
          }
      }
    }
    /*
public class MyClass {
    public static void main(String args[]) {
      int [][] arr={{1,2,3},{4,5,6},{7,8,9}};
      int row= arr.length;
      int col=arr[0].length;
      int [][]arr2=new int[row][col];
      
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr.length;j++){
              arr2[i][j]=arr[j][i];
              System.out.print(arr2[i][j]+" ");
          }
          System.out.println();
      }
    //   for(int i=0;i<arr2.length;i++){
    //       for(int j=0;j<arr2.length;j++){
    //          System.out.print(arr2[i][j]+" ");
    //       }
    //       System.out.println();
    //   }
    }
}
*/
          

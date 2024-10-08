//Boundary elemnts print
/*
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33  
*/
public class MyClass {
    public static void main(String args[]) {
     int [][] arr={{1,2,3,4},{5,6,7,8},{6,7,8,9}};
    int row= arr.length;
    int col= arr[0].length;
    //arr[0]: This expression accesses the first row of the array arr.
//.length: This property returns the number of elements in the array arr[0].
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(i==0 || j==0 || i==row-1 || j==col-1){
                System.out.print(arr[i][j]+" ");
            }
        }
    }
    }
}

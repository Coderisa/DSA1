//pair sum
import java.util.Scanner;
class pairSum
  {
    public static void main(String args[])
    {
      int arr[]={1,2,3,4,5,6};
      int sum=0;int n=arr.length;
      for(int i=0;i<n;i++)
        {
          for(int j=i+1;j<n;j++)
            {
              sum+=arr[i]+arr[j];
              System.out.println("total pair sum of "+arr[i] +"and"+arr[j]+"is"+sum);
            }
        }
    }
  }
      
        
      

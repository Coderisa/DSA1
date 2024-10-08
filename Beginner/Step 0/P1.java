/*
      1
    1 2
  1 2 3
1 2 3 4 
 */
import java.util.Scanner;
class P1{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();//Int ke baad () lagana bhool gayi madam
        for(int i=1;i<=N;i++)
        {
        for( int j=N;j>i;j--)
        {
            System.out.print(" ");//("") is wrong ;beech me space to dalo jan
        }
        for(int k=1;k<=i;k++)
        {
            System.out.print(k);
        }
        System.out.println();
        
        
    }
}
}
/*
        for (int i = 0; i < n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i - 1; j++) {
                System.out.print(" ");
            }
            
            // Print numbers
            for (int k = 1; k <= i + 1; k++) {
                System.out.print(k);
            }
            
            // Break the line
            System.out.println();
        }
    }
}
*/
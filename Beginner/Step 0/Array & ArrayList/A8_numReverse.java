//WAP to eneter range of number and print reverse of all the number in that range and their sum.
import java .util.Scanner ;
class reverse
  {
    public static void main (String args[])
    {
      Scanner sc=new Scanner (System.in);
      System.out.println("Enetr number range");
      int l=sc.nextInt();
      int e=sc.nextInt();
      int sum=0;
      for(int i=l;i<=e;i++)
        { 
          int rev =0;
          int num=i;
          while(num!=0)
            {
              int rem=num%10;
              rev=rev*10+rem;
              num=num/10;
            }//reverse of number at i
      System.out.println("Reverse of "+i+"is"+rev);
          sum+=rev;
        }
      System.out.println("Sum aof all reversed numbers in the range is "+ sum);
    }
  }

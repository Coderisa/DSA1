class Solution {
    public int maxSubArray(int[] nums) {

        int max=Integer.MIN_VALUE ,sum=0;//max=nums[0]
        for(int i=0;i<nums.length;i++)
        {
          sum+=nums[i];//Prefix sum
          max=Math.max(sum,max);// max=sum>max?sum:max;
          if(sum<0)//Agar sum -ve hai to vo subarray sum ko hamesha decrease hi karega 
          sum=0;//isliye sum ko 0 kardo
          

        }
        return max;
    }
}// agr [-1,-10,-3,-100,-2] all nums negative then also it will work becoz we have to return max not sum joki baar bar 0 ho jayega

            




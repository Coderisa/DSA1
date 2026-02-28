class Solution {
    public int[] searchRange(int[] nums, int target) {
    int b=0,e= nums.length-1,lb=-1,up=-1,mid;
    //first occurence
    while(b<=e)
    {
       mid=(b+e)/2;
       if(nums[mid]==target){
          lb=mid;
          e=mid-1;}//agr element mil gaya to jaroori nhi hai ki vo first occurence ho hi ,islye usko store karke e=mid-1 karenge
      else if(nums[mid]>target){//123
				e=mid-1;
			}
      
       else
          b=mid+1;//agr nhi mila to b ke left mein to pakka nhi hoga as elements are srted
    } //reset 
    
    if (lb!=-1) b=lb ;//optimization
    else b=0;
    e=nums.length-1;

     while(b<=e)
    {
       mid=(b+e)/2;
       if(nums[mid]==target){
          up=mid;
          b=mid+1;}
          
          else if(nums[mid]<target)
          b=mid+1;
       else
          e=mid-1;   //end ke baaad to element nhi hoga
    } 
    int arr[]={lb,up};
    return arr;


    }
}
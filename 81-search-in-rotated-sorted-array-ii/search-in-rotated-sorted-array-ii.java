class Solution {
    public boolean search(int[] nums, int target) {
        int b=0,e=nums.length-1;
        //metod 1 from pepcoding here we find mid and check ki kon sa region sorted hai.start to mid ya after mid ek to ho ga hi
        //then dorted region mein we check for our eleemnt and shift boundary
        while(b<=e){
            while(b<e &&nums[b]==nums[b+1]) b++;//to remove duplacate elements from start
            while(b<e && nums[e]==nums[e-1])e--;//,, from end
            int mid=b+(e-b)/2;
            if(target==nums[mid]){
            return true;}
            else if(nums[mid]>=nums[b]){
               if(target>=nums[b]&& target < nums[mid])
                  e=mid-1;
               else b=mid+1;}
            else{
              if(target>nums[mid]&& target <=nums[e])
                  b=mid+1;
               else
                e=mid-1;}
        }
        return false;
    }
}
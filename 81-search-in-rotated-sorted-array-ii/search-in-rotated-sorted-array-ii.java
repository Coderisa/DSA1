class Solution {
    public boolean search(int[] nums, int target) {
        int b=0,e=nums.length-1;
        while(b<=e){
            while(b<e &&nums[b]==nums[b+1]) b++;
            while(b<e && nums[e]==nums[e-1])e--;
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
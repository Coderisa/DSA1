class Solution {
    /*
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
}*/
//method 2-find pivot method
public boolean binarysearch(int[] nums, int b, int e, int target) {
    while (b <= e) {
        int mid = b + (e - b) / 2; // Corrected mid calculation
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] < target) {
            b = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return false;
}

public boolean search(int[] nums, int target) {
    int n = nums.length;
    int p = pivot(nums, 0, n - 1);
    // Search in the two portions divided by the pivot
    if (binarysearch(nums, 0, p - 1, target)) {
        return true;
    }
    return binarysearch(nums, p, n - 1, target);
}

int pivot(int[] nums, int b, int e) {
    while (b < e) {
        while (b < e && nums[b] == nums[b + 1]) {
            b++;
        }
        while (b < e && nums[e] == nums[e - 1]) {
            e--;
        }
        int mid = b + (e - b) / 2; // Corrected mid calculation
        if (nums[mid] <= nums[e]) { // Sorted part
            e = mid; // Possibly my pivot
        } else {
            b = mid + 1;
        }
    }
    return e; // Pivot index
}
}

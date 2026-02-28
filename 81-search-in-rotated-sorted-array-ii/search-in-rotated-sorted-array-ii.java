
    /*
    public boolean search(int[] nums, int target) {
        int b=0,e=nums.length-1;
        //metod 1 from pepcoding here we find mid and check ki kon sa region sorted hai.start to mid ya after mid ek to ho ga hi
        //then dorted region mein we check for our eleemnt and shift boundary
        while(b<=e){
            while(b<e &&nums[b]==nums[b+1]) b++;//to remove duplacate elements from start
            while(b<e && nums[e]==nums[e-1])e--;//,, from end
             
                You need to do what I did above because you'll fail in case like
                [1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]
                2
                Here, the nums[mid] <= nums[r] and
                and we will cut down the right half but our pivot lies there
                So, make it a RULE, whenever there are duplicate elements and you need to to something
                like Binary Search, you need to ignore duplicates like done above
                Similar Qn : "Smallest element in a rotated sorted array with duplicates"
            
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
/*
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
        //SKIP DUPLICATES FROM LEFT AND RIGHT
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

*/
class Solution {
    
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
       boolean ans = binaryS( pivot , nums.length-1 , nums, target);
       if (ans == true) return true ;
       else 
       return binaryS( 0 ,pivot -1 , nums, target);

       //OR  return binarySearch(nums, target, pivot, nums.length - 1) ||
             //  binarySearch(nums, target, 0, pivot - 1);
    }
  int   findPivot(int []nums){
    int l=0, r = nums.length -1;
    while(l< r){
        //SKIP DUPLICATES FROM LEFT AND RIGHT
        while (l < r && nums[l] == nums[l + 1]) {
            l++;
        }
        while (l < r && nums[r] == nums[r - 1]) {
            r--;
        }
        int mid = l+(r -l)/2;
        if(nums[mid] > nums[r])
          l = mid+1; // pivot is in the right half
      else
          r=mid;                 // nums[mid] == nums[r], cannot decide, shrink range
            
  }
   return l;
  }
boolean  binaryS(int  pivot ,int h ,int []nums,int  target){
   int l= pivot , r = h;
   while(l<= r){
    int mid = l+(r-l)/2;
    if(nums[mid]== target) return true;
    else if( nums[mid] >target) r = mid -1;
    else  l = mid+1;
   } 
   return false;
}

}




/*
class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}*/
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer>mp=new HashSet<>();
        for(int i:nums){
            if(mp.contains(i)) return i;
            else 
              mp.add(i);
        }
        return 0;
    }
}


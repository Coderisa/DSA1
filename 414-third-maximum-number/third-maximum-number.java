import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollLast(); // Remove the smallest if more than 3 distinct elements
            }
        }

        // If we have 3 distinct maximums, return the third
        return set.size() == 3 ? set.last() : set.first();
    }
}

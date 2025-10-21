import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> indexMap;
    private Random rand;

    public Solution(int[] nums) {
        indexMap = new HashMap<>();
        rand = new Random();

        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = indexMap.get(target);
        return indices.get(rand.nextInt(indices.size()));
    }
}

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        // Map to store each stone and the set of jump sizes that can reach it
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        // Initialize the map with empty sets for each stone
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        // The frog starts at stone 0 with a jump size of 0
        dp.get(0).add(0);

        // Iterate through each stone
        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                // Try jump sizes of k-1, k, and k+1
                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                    if (nextJump > 0 && dp.containsKey(stone + nextJump)) {
                        dp.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }

        // Check if the last stone has any reachable jump sizes
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}

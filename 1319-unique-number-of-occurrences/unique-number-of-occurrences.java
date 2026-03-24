class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count occurrences
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int a : arr) {
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }

        // Step 2: Check uniqueness of counts
        HashSet<Integer> seenCounts = new HashSet<>();
        for (int count : mp.values()) {
            if (!seenCounts.add(count)) {
                // If add returns false, count already exists → not unique
                return false;
            }
        }

        return true;
    }
}
class Solution {
    Map<Character, List<Integer>> charToIndices;
    int[][] memo;
    int ringLen;

    public int findRotateSteps(String ring, String key) {
        ringLen = ring.length();
        charToIndices = new HashMap<>();

        // Map each character to its positions in the ring
        for (int i = 0; i < ringLen; i++) {
            charToIndices.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }

        memo = new int[ringLen][key.length()];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(ring, key, 0, 0);
    }

    private int dfs(String ring, String key, int ringPos, int keyPos) {
        if (keyPos == key.length()) return 0;
        if (memo[ringPos][keyPos] != -1) return memo[ringPos][keyPos];

        char target = key.charAt(keyPos);
        int minSteps = Integer.MAX_VALUE;

        for (int idx : charToIndices.get(target)) {
            int steps = Math.min(Math.abs(ringPos - idx), ringLen - Math.abs(ringPos - idx));
            int total = steps + 1 + dfs(ring, key, idx, keyPos + 1); // +1 for pressing the button
            minSteps = Math.min(minSteps, total);
        }

        memo[ringPos][keyPos] = minSteps;
        return minSteps;
    }
}

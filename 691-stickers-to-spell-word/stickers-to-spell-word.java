import java.util.*;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickerCounts = new int[n][26];

        // Preprocess each sticker into a letter frequency array
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0); // Base case: no letters needed

        return helper(stickerCounts, target, memo);
    }

    private int helper(int[][] stickerCounts, String target, Map<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);

        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int minStickers = Integer.MAX_VALUE;

        for (int[] sticker : stickerCounts) {
            // Optimization: skip stickers that don't contain the first needed letter
            if (sticker[target.charAt(0) - 'a'] == 0) continue;

            // Build new target after applying this sticker
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int remaining = targetCount[i] - sticker[i];
                for (int j = 0; j < Math.max(0, remaining); j++) {
                    sb.append((char) ('a' + i));
                }
            }

            String newTarget = sb.toString();
            int res = helper(stickerCounts, newTarget, memo);
            if (res != -1) {
                minStickers = Math.min(minStickers, 1 + res);
            }
        }

        memo.put(target, minStickers == Integer.MAX_VALUE ? -1 : minStickers);
        return memo.get(target);
    }
}

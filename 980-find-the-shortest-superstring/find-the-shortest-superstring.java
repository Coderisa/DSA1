class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlap = new int[n][n];

        // Precompute overlaps: overlap[i][j] = max suffix of words[i] that matches prefix of words[j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int max = Math.min(words[i].length(), words[j].length());
                for (int k = max; k >= 0; k--) {
                    if (words[i].endsWith(words[j].substring(0, k))) {
                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }

        // dp[mask][i] = shortest superstring ending with words[i] using mask
        String[][] dp = new String[1 << n][n];
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = words[i];
        }

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) == 0 || dp[mask][last] == null) continue;
                for (int next = 0; next < n; next++) {
                    if ((mask & (1 << next)) != 0) continue;
                    int nextMask = mask | (1 << next);
                    String candidate = dp[mask][last] + words[next].substring(overlap[last][next]);
                    if (dp[nextMask][next] == null || candidate.length() < dp[nextMask][next].length()) {
                        dp[nextMask][next] = candidate;
                    }
                }
            }
        }

        // Find the shortest superstring among all possibilities
        String result = null;
        for (int i = 0; i < n; i++) {
            if (result == null || dp[(1 << n) - 1][i].length() < result.length()) {
                result = dp[(1 << n) - 1][i];
            }
        }

        return result;
    }
}

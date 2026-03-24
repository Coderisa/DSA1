import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> los = new HashMap<>();
        HashSet<Integer> win = new HashSet<>();

        for (int i = 0; i < matches.length; i++) {
            int w = matches[i][0];
            int l = matches[i][1];

            // Add winner if not already tracked as loser
            if (!los.containsKey(w)) {
                win.add(w);
            }

            // Count losses for each loser
            los.put(l, los.getOrDefault(l, 0) + 1);

            // If loser was in winners, remove them
            if (win.contains(l)) {
                win.remove(l);
            }
        }

        // Prepare result: winners (0 losses) and players with exactly 1 loss
        List<Integer> winners = new ArrayList<>(win);
        Collections.sort(winners);

        List<Integer> oneLoss = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : los.entrySet()) {
            if (entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
        }
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();
        result.add(winners);
        result.add(oneLoss);

        return result;
    }
}


/*
Brute force: Simple, but inefficient (O(n²)).

Optimized (HashMap + HashSet): Efficient (O(n log n)), clean, and scalable.

   import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // Collect all players
        Set<Integer> players = new HashSet<>();
        for (int[] match : matches) {
            players.add(match[0]); // winner
            players.add(match[1]); // loser
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        // For each player, brute force count losses by scanning all matches
        for (int player : players) {
            int lossCount = 0;
            for (int[] match : matches) {
                if (match[1] == player) {
                    lossCount++;
                }
            }

            if (lossCount == 0) {
                notLost.add(player);
            } else if (lossCount == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(notLost);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();
        result.add(notLost);
        result.add(oneLoss);

        return result;
    }
}

*/

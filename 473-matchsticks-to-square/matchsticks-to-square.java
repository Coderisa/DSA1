class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;

        int totalLength = 0;
        for (int stick : matchsticks) {
            totalLength += stick;
        }

        if (totalLength % 4 != 0) return false;
        int target = totalLength / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks); // Sort descending for better pruning

        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target &&
                   sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) continue;
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, sides, target)) return true;
            sides[i] -= matchsticks[index];
        }

        return false;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}

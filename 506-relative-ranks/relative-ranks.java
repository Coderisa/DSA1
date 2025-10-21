class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Copy and sort scores in descending order
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        reverse(sorted);

        // Map each score to its rank
        Map<Integer, String> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                rankMap.put(sorted[i], "Gold Medal");
            } else if (i == 1) {
                rankMap.put(sorted[i], "Silver Medal");
            } else if (i == 2) {
                rankMap.put(sorted[i], "Bronze Medal");
            } else {
                rankMap.put(sorted[i], String.valueOf(i + 1));
            }
        }

        // Build result using original score order
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(score[i]);
        }

        return result;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

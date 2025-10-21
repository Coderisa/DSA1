class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        int minSoFar = arrays.get(0).get(0);
        int maxSoFar = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            // Compare current array with global min/max from previous arrays
            maxDist = Math.max(maxDist, Math.abs(currMax - minSoFar));
            maxDist = Math.max(maxDist, Math.abs(maxSoFar - currMin));

            // Update global min/max
            minSoFar = Math.min(minSoFar, currMin);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxDist;
    }
}

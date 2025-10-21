import java.util.*;

class Solution {
    private int[][] rects;
    private int[] prefixSums;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        this.rand = new Random();

        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int count = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            sum += count;
            prefixSums[i] = sum;
        }
    }

    public int[] pick() {
        int target = rand.nextInt(prefixSums[prefixSums.length - 1]);

        // Binary search to find the rectangle
        int lo = 0, hi = prefixSums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < prefixSums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        int[] r = rects[lo];
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        return new int[]{x, y};
    }
}

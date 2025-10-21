class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) total += m;

        int n = machines.length;
        if (total % n != 0) return -1;

        int target = total / n;
        int maxMoves = 0;
        int balance = 0;

        for (int m : machines) {
            int diff = m - target;
            balance += diff;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(balance), diff));
        }

        return maxMoves;
    }
}

class Solution {
    private boolean isPossible(int[] nums, int mid, int k) {
        int house = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                house++;
                i++; // skipping adjacent house
            }
        }
        
        return house >= k; // we managed to rob at least k houses
    }
    
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();
        
        int result = r;
        
        while (l <= r) { // O(log(maxC) * n )
            int mid = l + (r - l) / 2; // capability
            
            if (isPossible(nums, mid, k)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return result;
    }
}

/*class Solution {
    private int n;
  public int minCapability(int[] nums, int k) {
        n = nums.length;
        int[][] t = new int[n + 1][k + 1];
        
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        
        return solve(nums, 0, k, t);
    }



    
    private int solve(int[] nums, int i, int k, int[][] t) {
        if (k == 0) {
            return 0; // no more house to be covered
        }
        
        if (i >= n) { // invalid path
            return Integer.MAX_VALUE;
        }
        
        if (t[i][k] != -1) {
            return t[i][k];
        }
        
        int take = Math.max(nums[i], solve(nums, i + 2, k - 1, t));
        int not_take = solve(nums, i + 1, k, t);
        
        return t[i][k] = Math.min(take, not_take);
    }
} */


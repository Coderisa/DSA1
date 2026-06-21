class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];
        Arrays.fill(prevGreater, -1);
        Arrays.fill(nextGreater, -1);

        Stack<Integer> stack = new Stack<>();

        // Previous greater element (nearest greater to the left)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevGreater[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Next greater element (nearest greater to the right)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prevGreater[i] != -1 && i - prevGreater[i] >= 2) {
                ans++;
            }
            if (nextGreater[i] != -1 && nextGreater[i] - i >= 2) {
                ans++;
            }
        }

        return ans;
    }
}


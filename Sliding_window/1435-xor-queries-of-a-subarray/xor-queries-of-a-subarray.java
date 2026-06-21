class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // Step 1: Build the prefix XOR array (size n+1)
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i]; 
            // At i=0: prefix[1] = 0 ^ arr[0] = arr[0]
            // At i=1: prefix[2] = arr[0] ^ arr[1]
        }

        // Step 2: Answer each query using the cancellation trick
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            answer[i] = prefix[right + 1] ^ prefix[left];
        }
        
        return answer;
    }
}
/* https://leetcode.com/discuss/post/5119937/prefix-sum-problems-by-c0d3m-08l9/#section-1 */
/* https://leetcode.com/discuss/post/4023666/prefix-sum-questions-to-practice-by-anon-g2q1/ */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        int maxLen = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int a = arr[i];
                int b = arr[j];
                int len = 2; // Initial length is 2 (a, b)

                while (indexMap.containsKey(a + b)) {
                    len++;
                    int next = a + b;
                    a = b;
                    b = next;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
}
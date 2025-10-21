class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int s1Len = s1.length(), s2Len = s2.length();
        int index = 0, count = 0;

        // Map to detect cycles: key = index in s2, value = [iteration of s1, count of s2]
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1Len; j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    index++;
                    if (index == s2Len) {
                        index = 0;
                        count++;
                    }
                }
            }

            if (map.containsKey(index)) {
                int[] prev = map.get(index);
                int prev_i = prev[0], prev_count = prev[1];

                int cycle_len = i - prev_i;
                int cycle_count = count - prev_count;

                int remaining = n1 - i - 1;
                int cycles = remaining / cycle_len;

                count += cycles * cycle_count;
                i += cycles * cycle_len;
            } else {
                map.put(index, new int[]{i, count});
            }
        }

        return count / n2;
    }
}

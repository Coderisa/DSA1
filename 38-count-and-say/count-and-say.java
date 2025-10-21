class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char curr = result.charAt(j);
                if (curr == prev) {
                    count++;
                } else {
                    next.append(count).append(prev);
                    count = 1;
                    prev = curr;
                }
            }

            next.append(count).append(prev); // Append last group
            result = next.toString();
        }

        return result;
    }
}

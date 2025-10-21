import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> segments, List<String> result) {
        // If we have 4 segments and reached the end of the string, it's a valid IP
        if (segments.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            // Skip invalid segments: leading zeros or >255
            if ((segment.length() > 1 && segment.startsWith("0")) || Integer.parseInt(segment) > 255) {
                continue;
            }

            segments.add(segment);
            backtrack(s, start + len, segments, result);
            segments.remove(segments.size() - 1); // Backtrack
        }
    }
}

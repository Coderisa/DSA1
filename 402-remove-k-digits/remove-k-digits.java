class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }

        // Remove remaining digits from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        // Build the result and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}


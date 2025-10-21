class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Repeat 'a' until its length is at least that of 'b'
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if 'b' is now a substring
        if (sb.toString().contains(b)) return count;

        // Append one more time to cover overlap cases
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) return count;

        return -1;
    }
}

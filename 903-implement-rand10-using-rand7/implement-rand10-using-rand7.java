class Solution extends SolBase {
    public int rand10() {
        while (true) {
            // Generate a number in [1,49] using rand7() twice
            int num = (rand7() - 1) * 7 + rand7(); // uniform in [1,49]
            if (num <= 40) {
                return 1 + (num - 1) % 10; // uniform in [1,10]
            }
            // Otherwise, reuse the leftover part to reduce waste
            num = (num - 40 - 1) * 7 + rand7(); // uniform in [1,63]
            if (num <= 60) {
                return 1 + (num - 1) % 10;
            }

            num = (num - 60 - 1) * 7 + rand7(); // uniform in [1,21]
            if (num <= 20) {
                return 1 + (num - 1) % 10;
            }
            // If still out of range, repeat
        }
    }
}

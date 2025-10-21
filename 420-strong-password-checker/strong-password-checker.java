class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        int replace = 0; // replacements needed for repeating characters
        int oneMod = 0, twoMod = 0; // counts of sequences with len % 3 == 1 or 2
        char[] chars = password.toCharArray();

        // Check character types and repeating sequences
        for (int i = 0; i < n;) {
            if (Character.isLowerCase(chars[i])) hasLower = true;
            if (Character.isUpperCase(chars[i])) hasUpper = true;
            if (Character.isDigit(chars[i])) hasDigit = true;

            int j = i;
            while (i < n && chars[i] == chars[j]) i++;
            int len = i - j;
            if (len >= 3) {
                replace += len / 3;
                if (len % 3 == 0) oneMod++;
                else if (len % 3 == 1) twoMod++;
            }
        }

        int missingTypes = 0;
        if (!hasLower) missingTypes++;
        if (!hasUpper) missingTypes++;
        if (!hasDigit) missingTypes++;

        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        } else if (n <= 20) {
            return Math.max(replace, missingTypes);
        } else {
            int delete = n - 20;
            int remainingDelete = delete;

            // Prioritize reducing replace count by deleting from sequences
            if (remainingDelete > 0 && oneMod > 0) {
                int used = Math.min(remainingDelete, oneMod);
                replace -= used;
                remainingDelete -= used;
            }
            if (remainingDelete > 0 && twoMod > 0) {
                int used = Math.min(remainingDelete, twoMod * 2) / 2;
                replace -= used;
                remainingDelete -= used * 2;
            }
            if (remainingDelete > 0) {
                int used = remainingDelete / 3;
                replace -= used;
            }

            return delete + Math.max(replace, missingTypes);
        }
    }
}

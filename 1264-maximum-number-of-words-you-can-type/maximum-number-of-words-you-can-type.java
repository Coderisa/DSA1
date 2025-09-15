class Solution {
    int check(String b, Set<Character> mp) {
        for (char f : b.toCharArray()) {
            if (mp.contains(f)) return 0;
        }
        return 1;
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        Set<Character> mp = new HashSet<>();
        for (char m : brokenLetters.toCharArray()) {
            mp.add(m);
        }

        String[] words = text.split(" ");
        for (String word : words) {
            ans += check(word, mp);
        }

        return ans;
    }
}

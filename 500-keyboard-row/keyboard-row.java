import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        Set<Character> set1 = toSet(row1);
        Set<Character> set2 = toSet(row2);
        Set<Character> set3 = toSet(row3);

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            if (belongsToOneRow(lower, set1) || belongsToOneRow(lower, set2) || belongsToOneRow(lower, set3)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private Set<Character> toSet(String row) {
        Set<Character> set = new HashSet<>();
        for (char c : row.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    private boolean belongsToOneRow(String word, Set<Character> rowSet) {
        for (char c : word.toCharArray()) {
            if (!rowSet.contains(c)) {
                return false;
            }
        }
        return true;
    }
}

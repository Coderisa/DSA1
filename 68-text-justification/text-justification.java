class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Find how many words fit in the current line
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - totalChars + (numWords - 1);

            // If it's the last line or only one word, left-justify
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                int remaining = maxWidth - line.length();
                while (remaining-- > 0) line.append(" ");
            } else {
                int spaceBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        int spacesToApply = spaceBetween + (extraSpaces-- > 0 ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}

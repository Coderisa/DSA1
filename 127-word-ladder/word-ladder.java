class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int curLevelSize = q.size();
            for (int i = 0; i < curLevelSize; i++) {
                String node = q.poll();
                if (node.equals(endWord)) return level;

                List<String> neighbours = getNeighbours(node, set);
                for (String word : neighbours) {
                    q.offer(word);
                    set.remove(word);
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> getNeighbours(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) continue;
                String newWord = word.substring(0, i) + ch + word.substring(i + 1);
                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
}

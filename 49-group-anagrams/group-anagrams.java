class Solution {
    public List <List<String>> groupAnagrams(String[] strs) {
          Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the string to form a key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
    

 /*class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();

        // Insert all prefixes of elements from arr1 into the set
        for (int val : arr1) {
            while (!st.contains(val) && val > 0) {
                st.add(val);
                val = val / 10;  // Trim last digit
            }
        }

        int result = 0; // LCP
        for (int num : arr2) {
            while (!st.contains(num) && num > 0) {
                num /= 10;  // Trim last digit
            }

            if (num > 0) {
                result = Math.max(result, (int) (Math.log10(num) + 1));
            }
        }

        return result;
    }
}

*/
class TrieNode {
    TrieNode[] children = new TrieNode[10];  // 0, 1, 2...9
}

class Solution {

    public TrieNode getTrieNode() {
        return new TrieNode();
    }

    public void insert(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    // Returns the length of the longest prefix
    public int search(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] != null) {
                length++;
                crawl = crawl.children[idx];
            } else {
                break;
            }
        }

        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getTrieNode();  // TRIE

        // Insert all elements of arr1 into the trie
        for (int num : arr1) {
            insert(num, root);
        }

        int result = 0;
        // Search for the longest common prefix in arr2
        for (int num : arr2) {
            result = Math.max(result, search(num, root));
        }

        return result;
    }
}
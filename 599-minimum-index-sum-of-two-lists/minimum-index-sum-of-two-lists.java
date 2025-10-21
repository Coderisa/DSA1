import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Store list1 strings and their indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // Traverse list2 and check for common strings
        for (int j = 0; j < list2.length; j++) {
            String s = list2[j];
            if (map.containsKey(s)) {
                int sum = map.get(s) + j;
                if (sum < minSum) {
                    result.clear();
                    result.add(s);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(s);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}

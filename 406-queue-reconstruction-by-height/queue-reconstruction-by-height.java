import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people by descending height.
        // If heights are equal, sort by ascending k-value.
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // taller first
            return a[1] - b[1]; // smaller k first
        });

        List<int[]> result = new LinkedList<>();

        // Insert each person at the index equal to their k-value
        for (int[] person : people) {
            result.add(person[1], person);
        }

        // Convert the list back to an array
        return result.toArray(new int[people.length][2]);
    }
}

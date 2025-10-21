import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = boardToString(board);

        // Neighbor indices for each position in the 2x3 board
        int[][] neighbors = {
            {1, 3},    // index 0
            {0, 2, 4}, // index 1
            {1, 5},    // index 2
            {0, 4},    // index 3
            {1, 3, 5}, // index 4
            {2, 4}     // index 5
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(target)) return moves;

                int zeroIndex = curr.indexOf('0');
                for (int neighbor : neighbors[zeroIndex]) {
                    String next = swap(curr, zeroIndex, neighbor);
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int val : row) {
                sb.append(val);
            }
        }
        return sb.toString();
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // PriorityQueue to store [value, column, row]
        // Sorted by: column (asc) -> row (asc) -> value (asc)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {          // Compare column
                return Integer.compare(a[1], b[1]);
            } else if (a[2] != b[2]) {   // Compare row
                return Integer.compare(a[2], b[2]);
            } else {                      // Compare value
                return Integer.compare(a[0], b[0]);
            }
        });

        // BFS Queue: stores [TreeNode, column]
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0});
        int row = 0; // Tracks current level/row in the tree

        while (!queue.isEmpty()) {
            int size = queue.size(); // FIX: Store size before looping
            
            for (int i = 0; i < size; i++) {
                Object[] current = queue.poll();
                TreeNode node = (TreeNode) current[0];
                int col = (int) current[1];

                // Add to PriorityQueue
                pq.offer(new int[]{node.val, col, row});

                // Add children with updated columns
                if (node.left != null) {
                    queue.offer(new Object[]{node.left, col - 1});
                }
                if (node.right != null) {
                    queue.offer(new Object[]{node.right, col + 1});
                }
            }
            row++; // Move to the next level
        }

        // Extract grouped values from PriorityQueue
        if (pq.isEmpty()) return result;

        // Initialize with the first element
        int[] first = pq.poll();
        int currentCol = first[1];
        List<Integer> group = new ArrayList<>();
        group.add(first[0]);

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int val = pair[0];
            int col = pair[1];

            if (col == currentCol) {
                group.add(val);
            } else {
                result.add(group);          // Save previous column group
                group = new ArrayList<>();  // Start new group
                group.add(val);
                currentCol = col;
            }
        }
        result.add(group); // Don't forget the last group

        return result;
    }
}
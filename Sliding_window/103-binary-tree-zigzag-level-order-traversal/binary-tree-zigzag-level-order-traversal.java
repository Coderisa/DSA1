import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Guard clause: handle empty tree
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Create a new list for the current level
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level in NORMAL order
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // The Magic Line: If it's an ODD level, reverse the list!
            if (level % 2 != 0) {
                Collections.reverse(currentLevel);
            }

            // Add the (possibly reversed) list to the result
            result.add(currentLevel);
            level++;
        }

        return result;
    }
}
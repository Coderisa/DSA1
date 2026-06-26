import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    
    // ==================== Approach 1: BFS (main method) ====================
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean pastNull = false;  // have we seen a null node before?
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                pastNull = true;
            } else {
                if (pastNull) {
                    return false;   // non-null after a null → incomplete
                }
                // add both children (even if null)
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
/*
    // ==================== Approach 2: DFS (alternative) ====================
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private boolean dfsCheck(TreeNode root, int index, int totalNodes) {
        if (root == null) return true;
        if (index > totalNodes) return false;
        return dfsCheck(root.left, 2 * index, totalNodes) &&
               dfsCheck(root.right, 2 * index + 1, totalNodes);
    }
    
    public boolean isCompleteTreeDFS(TreeNode root) {
        if (root == null) return true;
        int total = countNodes(root);
        return dfsCheck(root, 1, total);
    }
}
*/
import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        // Base case: empty subtree
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Try each number as root
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);

            // Combine each left and right subtree with root i
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }
}

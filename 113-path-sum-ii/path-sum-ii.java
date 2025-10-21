class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        currentPath.add(node.val);
        remainingSum -= node.val;

        // Check if it's a leaf node and the path sum equals targetSum
        if (node.left == null && node.right == null && remainingSum == 0) {
            result.add(new ArrayList<>(currentPath)); // Add a copy of the current path
        } else {
            dfs(node.left, remainingSum, currentPath, result);
            dfs(node.right, remainingSum, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1); // Backtrack
    }
}

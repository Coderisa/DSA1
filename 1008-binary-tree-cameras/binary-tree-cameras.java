class Solution {
    private int cameraCount = 0;

    public int minCameraCover(TreeNode root) {
        // If root is not monitored, we need one more camera
        if (dfs(root) == 0) {
            cameraCount++;
        }
        return cameraCount;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 2; // null nodes are considered monitored

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cameraCount++;
            return 1; // place camera here
        }

        if (left == 1 || right == 1) {
            return 2; // this node is monitored
        }

        return 0; // this node is not monitored
    }
}

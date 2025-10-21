class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Special case: insert new root
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        insertRow(root, val, 1, depth);
        return root;
    }

    private void insertRow(TreeNode node, int val, int currentDepth, int targetDepth) {
        if (node == null) return;

        if (currentDepth == targetDepth - 1) {
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;

            node.left = new TreeNode(val, tempLeft, null);
            node.right = new TreeNode(val, null, tempRight);
        } else {
            insertRow(node.left, val, currentDepth + 1, targetDepth);
            insertRow(node.right, val, currentDepth + 1, targetDepth);
        }
    }
}

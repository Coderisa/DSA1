class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null → trees match at this branch
        if (p == null && q == null) return true;

        // One node is null, the other isn't → mismatch
        if (p == null || q == null) return false;

        // Values differ → mismatch
        if (p.val != q.val) return false;

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

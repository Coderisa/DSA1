class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        // Connect left child to right child
        if (root.left != null) {
            root.left.next = root.right;
        }

        // Connect right child to the next node's left child
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        // Recurse on left and right subtrees
        connect(root.left);
        connect(root.right);

        return root;
    }
}

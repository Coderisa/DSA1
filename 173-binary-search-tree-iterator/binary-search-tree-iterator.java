import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftBranch(root);
    }

    // Push all left children of a node onto the stack
    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Returns the next smallest number
    public int next() {
        TreeNode current = stack.pop();
        if (current.right != null) {
            pushLeftBranch(current.right);
        }
        return current.val;
    }

    // Returns true if there is a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

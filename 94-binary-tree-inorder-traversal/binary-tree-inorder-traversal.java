import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inorder(node.left, result);    // Traverse left
         result.add(node.val);           // Visit root
        inorder(node.right, result);   // Traverse right
    }
}
    
/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // Traverse the tree
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current is null at this point
            current = stack.pop();
            result.add(current.val); // Visit the node
            current = current.right; // Move to right subtree
        }

        return result;
    }
}
*/

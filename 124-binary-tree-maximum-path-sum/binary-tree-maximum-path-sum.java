//Approach - Recursively finding the best path
//T.C : O(n)
//S.C : O(n)
class Solution {
    
    private int maxSum;
    
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int neecheHiMilgayaAnswer = left + right + root.val; // (1)
        int koiEkAcha = Math.max(left, right) + root.val; // (2)
        int onlyRootAcha = root.val; // (3)

        maxSum = Math.max(maxSum, Math.max(neecheHiMilgayaAnswer, Math.max(koiEkAcha, onlyRootAcha)));
        
        // Most important part
        return Math.max(koiEkAcha, onlyRootAcha);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}

/*class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max gain from left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);  // Ignore negative paths
        int rightGain = Math.max(maxGain(node.right), 0);

        // Path sum including both children and current node
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global max if current path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain to parent (only one side can be chosen)
        return node.val + Math.max(leftGain, rightGain);
    }
}*/

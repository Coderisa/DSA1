/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        int sum =2;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int c=0;
        while(!q.isEmpty()) {
            int len =q.size();
             for(int i=0;i<len;i++){
                TreeNode node = q.poll();
                if( node.left!= null &&(node.left.val==x ||node.left.val==y)){
                    sum--;
                    if(node.right!= null &&(node.right.val==x||node.right.val==y)) return false;

                }
                if(node.right!= null &&(node.right.val==x|| node.right.val == y)) sum--;
                if(sum == 0) return true;
                if (node.left!=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
             }
             if(sum==1)return false;
        } return false;
    }
}
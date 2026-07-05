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
    boolean ans=false;
      HashSet<Integer>mp=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
      
        if(root ==  null) return false;
      ans=  findTarget(root.left, k);
      if(ans ==true) return true;

       if (mp.contains( k - root.val)) return true;
       else
         mp.add(root.val);

       ans = findTarget(root.right, k);
       if(ans == true) return true;

       return false;
    }
}
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
 /*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

   List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}
  */  
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int l=q.size();
            ArrayList<Integer>a=new ArrayList<>();

            for(int i=0;i<l;i++){
               TreeNode temp= q.poll();
               a.add(temp.val);

               if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            res.add(a);
        }
        return res;
    }
}
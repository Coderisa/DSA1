/*class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}//TIP: Inorder traversal of a Binary Search Tree is always sorted.
*/


class Solution {
    private int count = 0;
    int result =-1;
    

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
       result= kthSmallest(root.left,k);
       if(result != -1) return result;

       if(count +1 ==k)  return root.val;
       else 
           count++;
        
        result = kthSmallest(root.right,k);
        if(result != -1) return result;

        return result;

    }
}

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

// we hv used In-order traversal just becoz we know that using it we 'll have to just traverse the sorted tree values as it traveses in sorted order;
//varna pahle sort karna padta tree ko then ans ata.-O(nlogn)

class Solution {
    private int count = 0;
    //int result =-1;//we r using a neg value here as we know from the constraints that node.val can never be neg
    

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;//to indicate that kth abhi tak nhi mila hai

    int   result= kthSmallest(root.left,k);//we r not checking if (root.left!=null) as wven if it is null then it will return -1 not go further
       if(result != -1) return result;

       if(count +1 ==k)  return root.val;
       else 
           count++;//update count
        
       result = kthSmallest(root.right,k);
        if(result != -1) return result;

        return result;

    }
}

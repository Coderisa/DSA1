
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 level order traversal */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder(); // result of serialization
        Queue<TreeNode> q = new LinkedList(); // Queue for Level Order Traveral

        q.offer(root);
        while(!q.isEmpty()){
            // System.out.println(q);
            for(int i=1 ; i<=q.size() ; i++){
                TreeNode node = q.poll(); // extract node from Queue
                if (node == null){ // if Node == NULL add NULL to Serialized String
                    res.append(" null");
                    continue;
                }
                else // Else add Node's Value
                    res.append(" "+node.val);
                
                q.offer(node.left); // Go Left

                q.offer(node.right); // Go Right

            }
            
        }
        return res.toString().strip(); // Strip is done as there will be a white space at the beginnings
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(" "); // Split String on WhiteSpace
        if (d[0].compareTo("null") == 0) // if 1st Element i.e Root is Null return Null as result
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(d[0])); // Create Root
        // Add it to the Queue
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        int index = 1; // For every node we will take out 2 values
        // From String Array and use them to create left and right children
        // Initializing Index = 1 and Not Index = 0 as Index = 0 will be 
        // root and is already considered

        // Value Point By Index ==> Left Child
        // Value Point By Index + 1 ==> Right Child
        while(!q.isEmpty()){
            for(int i=1 ; i<=q.size() ; i++){
                TreeNode node = q.poll();

                if (d[index].compareTo("null") == 0 ) // If String at Index in String Array is null 
// then set the node.left to Null
                    node.left = null; 
                else
                {
                    TreeNode left = new TreeNode(Integer.parseInt(d[index]));
                // If we do not find "null" at Index then convert it to INT
                // Add it to Queue and to left of current Node

                    q.offer(left);
                    node.left = left;
                }

                if (d[index+1].compareTo("null") == 0 )
                // If Index+1 == null
                // Set Node.right == null
                    node.right = null;
                else{
                    TreeNode right = new TreeNode(Integer.parseInt(d[index+1]));
                // Convert (Index + 1) --> INT & Create a node
                // Add it to Queue
                // Set right of current node to newly created Node
                    q.offer(right);
                    node.right = right;
                }
                index+=2;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
 /* preorder traversal 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder b = new StringBuilder();
      //preorder has recursuion which can only be possible by making anothr fn
        preOrder(root,b);
        return b.toString();
    }
   void preOrder(TreeNode root, StringBuilder b){
    if(root == null) b.append("null");
  else{
        b.append(root.val,b);
       preOrder(root.left,b);
       preOder(root.right,b);
  }
      
   }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []split = data.split(",");
        List<String> st= new ArrayList<>(Arrays.asList(split));
        return PreOrder(st);
    }
    TreeNode preOrder(List<String>st){
        String s= st.get(0);
        if(s.equals("null")){
        list.remove(0);
         return null;}
        else{
            int num= Integer.parseInt(s);
            TreeNode root = new TreeNode(num);
            list.remove(0);
            root.left= preOrder(st);
            root.right=preorder(st);
        }
        return root;
    }
}
*/
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
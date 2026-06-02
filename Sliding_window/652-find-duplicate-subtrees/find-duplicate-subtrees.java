import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();   // Store serialization string and its occurrence count
        List<TreeNode> result = new ArrayList<>();    // Store root nodes of duplicate subtrees
        postOrder(root, map, result);
        return result;
    }

    private String postOrder(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) {
            return "#";    // Use "#" to represent null
        }
        String left = postOrder(node.left, map, result);
        String right = postOrder(node.right, map, result);
        // Build the serialization key – common patterns are "val,left,right" or "left,right,val"
        String key = node.val + "," + left + "," + right;
        map.put(key, map.getOrDefault(key, 0) + 1);
        // Only add when the second occurrence is found, to avoid duplicates in the result list
        if (map.get(key) == 2) {
            result.add(node);
        }
        return key;
    }
}
/*
class Solution {
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        HashMap<String,Integer> map= new HashMap<>();
        getSubTreeString(root,map);
        return ans;
    }

    String getSubTreeString(TreeNode root,HashMap<String,Integer> map){
        if(root==null)return "n";

        String s= Integer.toString(root.val) + ","+getSubTreeString(root.left,map)+ ","+getSubTreeString(root.right,map);

        if(map.containsKey(s) && map.get(s)==1){
            ans.add(root);
        }
        map.put(s,map.getOrDefault(s,0)+1);

        return s;
    }
}*/
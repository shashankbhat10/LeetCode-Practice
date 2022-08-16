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
    int postorder_index;
    HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorder_index = postorder.length - 1;
        
        int index_val = 0;
        
        for(Integer in : inorder){
            index.put(in, index_val++);
        }
        
        return helper(0, inorder.length - 1, inorder, postorder);
    }
    
    public TreeNode helper(int inorder_left, int inorder_right, int[] inorder, int[] postorder){
        if(inorder_left > inorder_right){
            return null;
        }
        
        int root_val = postorder[postorder_index];
        TreeNode root = new TreeNode(root_val);
        
        int index_val = index.get(root_val);
        
        postorder_index--;
        
        root.right = helper(index_val + 1, inorder_right, inorder, postorder);
        
        root.left = helper(inorder_left, index_val - 1, inorder, postorder);
        
        return root;
    }
}
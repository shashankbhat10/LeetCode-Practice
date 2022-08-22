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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return true;
        
        queue.add(root.left);
        queue.add(root.right);
        
        while(queue.size() > 1){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        
        return true;
    }
}
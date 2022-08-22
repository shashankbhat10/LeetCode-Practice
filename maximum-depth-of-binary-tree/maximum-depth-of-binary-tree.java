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
    public int maxDepth(TreeNode root) {
//         if(root == null)
//             return 0;
        
//         int left_height = maxDepth(root.left);
//         int right_height = maxDepth(root.right);
//         return Math.max(left_height, right_height) + 1;
        if(root == null)
            return 0;
        
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int len = queue.size();
            
            for(int i = 0; i< len; i++){
                TreeNode node = queue.remove();
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        
        return level;
    }
}
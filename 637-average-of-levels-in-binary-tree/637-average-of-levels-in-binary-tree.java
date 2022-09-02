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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> result = new LinkedList<Double>();
        
        if(root == null)
            return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int len = queue.size();
            double sum = 0;
            int i = 0;
            while(i < len){
                TreeNode node = queue.remove();
                sum += (double)node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                
                i++;
            }
            
            result.add((sum / (double) len));
        }
        
        return result;
    }
}
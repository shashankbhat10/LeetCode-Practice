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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        while(!queue.isEmpty()){            
            result.add(new ArrayList<Integer>());
            
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.remove();
                
                result.get(level).add(node.val);
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        
        return result;
    }
}
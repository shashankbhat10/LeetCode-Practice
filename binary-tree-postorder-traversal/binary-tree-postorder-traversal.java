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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> temp = new Stack<TreeNode>();
        Stack<TreeNode> post = new Stack<TreeNode>();
        
        if(root == null)
            return result;
        temp.push(root);
        
        while(!temp.isEmpty()){
            TreeNode node = temp.pop();
            post.push(node);
            if(node.left != null)
                temp.push(node.left);
            if(node.right != null)
                temp.push(node.right);
        }
        
        while(!post.isEmpty()){
            TreeNode node = post.pop();
            result.add(node.val);
        }
        
        return result;
    }
}
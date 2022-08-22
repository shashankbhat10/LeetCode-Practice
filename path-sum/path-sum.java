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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sum = new Stack<Integer>();
        
        if(root == null)
            return false;
        
        stack.push(root);
        sum.push(root.val);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int temp = sum.pop();
            
            if(node.left == null && node.right == null){
                if(temp == targetSum)
                    return true;
            } else {
                if(node.left != null){
                    stack.push(node.left);
                    sum.push(temp + node.left.val);
                }
                if(node.right != null){
                    stack.push(node.right);
                    sum.push(temp + node.right.val);
                }
            }
        }
        return false;
    }
}
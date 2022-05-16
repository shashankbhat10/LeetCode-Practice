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
    int maxLevel = 0;
    int maxSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        
        treeSum(root, 0);
        return maxSum;
    }
    
    private void treeSum(TreeNode root, int level){
        if(root == null)
            return;
        else if(level > maxLevel){
            maxLevel = level;
            maxSum = 0;
        }
        
        if(level == maxLevel){
            maxSum += root.val;
        }
        
        treeSum(root.left, level+1);
        treeSum(root.right, level+1);
    }
}
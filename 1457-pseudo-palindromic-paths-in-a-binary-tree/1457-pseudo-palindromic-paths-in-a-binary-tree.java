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
    int ans = 0;
    int[] digits = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return ans;
    }
    
    private void helper(TreeNode root){
        if(root == null)
            return;
        
        digits[root.val]++;
        if(root.left == null && root.right == null){
            int count = 0;
            for(int i=0; i<10;i++){
                count += digits[i]%2;
            }
            if(count == 1 || count == 0)
                ans++;
        }
        
        helper(root.left);
        helper(root.right);
        digits[root.val]--;
    }
}
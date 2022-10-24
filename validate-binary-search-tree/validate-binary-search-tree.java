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
    public boolean isValidBST(TreeNode root) {
        List<Integer> arr = new ArrayList<Integer>();
        if(root == null)
            return false;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // stack.push(root);
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                arr.add(curr.val);
                curr = curr.right;
            }
        }
        
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i-1) >= arr.get(i))
                return false;
        }
        
        return true;
    }
}
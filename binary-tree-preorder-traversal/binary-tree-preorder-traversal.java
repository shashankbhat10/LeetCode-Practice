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
    public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> output = new LinkedList<Integer>();
        
//         if(root == null)
//             return output;
        
//         Stack<TreeNode> stack = new Stack<TreeNode>();
        
//         stack.push(root);
//         while(!stack.isEmpty()){
//             TreeNode node = stack.pop();
            
//             output.add(node.val);
            
//             if(node.right != null)
//                 stack.push(node.right);
//             if(node.left != null)
//                 stack.push(node.left);
//         }
        
//         return output;
        
        List<Integer> output = new ArrayList<Integer>();
        
        if(root == null)
            return output;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            
            output.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        
        return output;
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null)
            return res;
        
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            // if(len == 1)
            //     res.add(node.val);
            while(len != 0){
                TreeNode node = q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                if(len == 1)
                    res.add(node.val);
                len--;
            }
            
            // TreeNode lastNode = q.remove();
            // res.add(lastNode.val);
        }
        return res;
    }
}
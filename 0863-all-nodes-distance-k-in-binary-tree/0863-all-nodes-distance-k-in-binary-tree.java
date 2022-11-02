/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<Integer> set = null;
    Map<Integer, List<Integer>> adjList;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        set = new HashSet<Integer>();
        adjList = new HashMap<Integer, List<Integer>>();
        buildGraph(root);
        
        if(adjList.keySet().size() == 0 && k > 0)
            return new ArrayList<Integer>();
        else if(k == 0){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(target.val);
            return temp;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(target.val);
        set.add(target.val);
        int level = 0;
        boolean breakLoop = false;

        while(!breakLoop){
            int size = queue.size();
            
            while(size > 0){
                int num = queue.remove();
                List<Integer> temp = adjList.get(num);
                for(int n : temp){
                    if(!set.contains(n)){
                        queue.add(n);
                        set.add(n);
                    }
                }
                size--;
            }
            level++;
            if(level == k){
                breakLoop = true;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            result.add(queue.remove());
        }
        
        return result;
    }
    
    private void buildGraph(TreeNode root){
        if(root == null)
            return;
        
        List<Integer> rootList = null;
        List<Integer> leftList = null;
        List<Integer> rightList = null;
        if(root.left != null){
            if(adjList.containsKey(root.val)){
                rootList = adjList.get(root.val);
            } else {
                rootList = new ArrayList<Integer>();
            }
            rootList.add(root.left.val);
            adjList.put(root.val, rootList);
            
            if(adjList.containsKey(root.left.val)){
                leftList = adjList.get(root.left.val);
            } else {
                leftList = new ArrayList<Integer>();
            }
            leftList.add(root.val);
            adjList.put(root.left.val, leftList);
        }
        if(root.right != null){
            if(adjList.containsKey(root.val)){
                rootList = adjList.get(root.val);
            } else {
                rootList = new ArrayList<Integer>();
            }
            rootList.add(root.right.val);
            adjList.put(root.val, rootList);
            
            if(adjList.containsKey(root.right.val)){
                rightList = adjList.get(root.right.val);
            } else {
                rightList = new ArrayList<Integer>();
            }
            rightList.add(root.val);
            adjList.put(root.right.val, rightList);
        }
        
        buildGraph(root.left);
        buildGraph(root.right);
        
        // set.add(root.val);
    }
}
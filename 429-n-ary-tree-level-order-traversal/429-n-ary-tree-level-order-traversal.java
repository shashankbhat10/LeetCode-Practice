/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            int len = queue.size();
            while(len > 0){
                Node node = queue.remove();
                temp.add(node.val);
                List<Node> children = node.children;
                for(Node child : children){
                    queue.add(child);
                }
                len--;
            }
            result.add(temp);
        }
        return result;
    }
}
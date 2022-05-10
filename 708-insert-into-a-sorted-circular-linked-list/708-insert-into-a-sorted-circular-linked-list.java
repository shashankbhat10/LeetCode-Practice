/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        
        Node curr = head.next;
        Node prev = head;
        while(curr != head){
            if(prev.val <= newNode.val && newNode.val <= curr.val)
                break;
            else if(prev.val > curr.val && prev.val <= newNode.val)
                break;
            else if(prev.val > curr.val && curr.val >= newNode.val)
                break;
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        
        prev.next = newNode;
        newNode.next = curr;
        return head;
    }
}
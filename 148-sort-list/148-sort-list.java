/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        ListNode curr = head;
        
        while(curr != null){
            q.add(curr.val);
            curr = curr.next;
        }
        
        ListNode node = new ListNode(q.peek());
        node.next = null;
        q.remove();
        curr = node;
        while(!q.isEmpty()){
            ListNode temp = new ListNode(q.remove());
            temp.next = null;
            curr.next = temp;
            curr = curr.next;
        }
        
        return node;
    }
}
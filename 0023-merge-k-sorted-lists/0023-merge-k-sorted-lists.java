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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        
        int i=0;
        while(i < lists.length){
            ListNode head = lists[i];
            while(head != null){
                queue.add(head);
                head = head.next;
            }
            i++;
        }
        
        if(queue.size() == 0)
            return null;
        ListNode temp = new ListNode(0);
        temp.next = queue.remove();
        ListNode curr = temp.next;
        while(!queue.isEmpty()){
            curr.next = queue.remove();
            curr = curr.next;
        }
        
        curr.next = null;
        return temp.next;
    }
}
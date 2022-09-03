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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        
        if(n == len){
            return head.next;
        }
        
        int i=0;
        while(i < len - n){
            prev = curr;
            curr = curr.next;
            i++;
        }
        
        prev.next = curr.next;
        curr.next = null;
        return head;
    }
}
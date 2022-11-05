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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        if(head == null)
            return head;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        k %= len;
        int n = len - k;
        
        if(head == null || k == 0)
            return head;
        
        ListNode curr = head;
        ListNode prev = null;
        while(n != 0){
            prev = curr;
            curr = curr.next;
            n--;
        }
        
        prev.next = null;
        temp = curr;
        while(temp.next != null){
            temp = temp.next;
        }
        
        temp.next = head;
        return curr;
    }
}
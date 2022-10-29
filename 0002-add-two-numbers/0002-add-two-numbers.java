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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode resHead = new ListNode(-1);
        ListNode curr = resHead;
        while(head1 != null && head2 != null){
            sum  = (head1.val + head2.val + carry) % 10;
            carry = (head1.val + head2.val + carry) / 10;
            
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        while(head1 != null){
            sum = (head1.val + carry) % 10;
            carry = (head1.val + carry) / 10;
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            head1 = head1.next;
        }
        
        while(head2 != null){
            sum = (head2.val + carry) % 10;
            carry = (head2.val + carry) / 10;
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            head2 = head2.next;
        }
        
        if(carry != 0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        
        curr.next = null;
        return resHead.next;
    }
}
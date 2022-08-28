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
        ListNode reversel1 = reverseList(l1);
        ListNode reversel2 = reverseList(l2);
        
        ListNode result = new ListNode((reversel1.val + reversel2.val) % 10);
        int carry = (reversel1.val + reversel2.val) / 10;
        ListNode curr = result;
        reversel1 = reversel1.next;
        reversel2 = reversel2.next;
        
        while(reversel1 != null || reversel2 != null){
            ListNode node;
            if(reversel1 == null){
                node = new ListNode((reversel2.val + carry) % 10);
                carry = (reversel2.val + carry) / 10;
                reversel2 = reversel2.next;
            } else if(reversel2 == null){
                node = new ListNode((reversel1.val + carry) % 10);
                carry = (reversel1.val + carry) / 10;
                reversel1 = reversel1.next;
            } else {
                node = new ListNode((reversel1.val + reversel2.val + carry) % 10);
                carry = (reversel1.val + reversel2.val + carry) / 10;
                reversel1 = reversel1.next;
                reversel2 = reversel2.next;
            }
            
            curr.next = node;
            curr = curr.next;
        }
        
        if(carry != 0){
            ListNode node = new ListNode(carry);
            curr.next = node;
            curr = curr.next;
        }
        
        curr.next = null;
        result = reverseList(result);
        return result;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}
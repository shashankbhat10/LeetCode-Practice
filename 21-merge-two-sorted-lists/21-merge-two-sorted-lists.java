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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode headRes = new ListNode(-1);
        ListNode curr = headRes;
        
        while(head1 != null || head2 != null){
            ListNode temp;
            if(head2 == null){
                temp = new ListNode(head1.val);
                head1 = head1.next;
            } else if(head1 == null) {
                temp = new ListNode(head2.val);
                head2 = head2.next;
            } else if(head1.val <= head2.val){
                temp = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                temp = new ListNode(head2.val);
                head2 = head2.next;
            }
            
            curr.next = temp;
            curr = curr.next;
        }
        
        curr.next = null;
        
        return headRes.next;
    }
}
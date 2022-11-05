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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2)
            return head;
        
        ListNode tempHead = new ListNode(-1);
        ListNode prevHead = tempHead;
        prevHead.next = head;
        ListNode curr = head;
        
        // breakLoop = false;
        while(true){
            int len = 0;
            ListNode startNode = curr;
            ListNode afterTail = null;
            while(curr != null && len != k){
                curr = curr.next;
                len++;
            }
            
            if(len < k)
                break;
            
            System.out.println("length: " + len);
            afterTail = curr;
            ListNode newHead = reverseList(startNode, k);
            System.out.println("newHead: " + newHead.val);
            prevHead.next = newHead;
            
            while(len != 1){
                newHead = newHead.next;
                len--;
            }
            System.out.println("newTail: " + newHead.val);
            newHead.next = afterTail;
            prevHead = newHead;
            newHead = newHead.next;
            curr = newHead;
            // System.out.println(curr.val);
        }
        
        return tempHead.next;
    }
    
    private ListNode reverseList(ListNode head, int length){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null && length != 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            length--;
        }
        
        return prev;
    }
}
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
    public ListNode swapPairs(ListNode head) {
//         if(head == null || head.next == null){
//             return head;
//         }
        
//         ListNode newHead = head.next;
//         ListNode curr = head;
//         ListNode nextNode = head.next;
//         ListNode prev = null;
//         while(curr != null && nextNode != null){
//             curr.next = nextNode.next;
//             nextNode.next = curr;
//             if(prev != null){
//                 prev.next = nextNode;
//             }
//             if(curr.next == null)
//                 break;
//             nextNode = curr.next.next;
//             prev = curr;
//             curr = curr.next;
//         }
//         return newHead;
        if(head == null || head.next == null)
            return head;
        
        ListNode node = swapPairs(head.next.next);
        
        ListNode temp = head.next;
        temp.next = head;
        head.next = node;
        return temp;
        
    }
}
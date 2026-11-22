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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null,curr = head,next=head;

        while (curr != null) {
            next = curr.next;   // Save next node
            curr.next = prev;   // Reverse link
            prev = curr;        // Move prev ahead
            curr = next;        // Move curr ahead
        }
        return prev;
    
    }
}

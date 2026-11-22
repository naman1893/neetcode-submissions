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
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1) Find middle (slow ends at mid for odd, first mid for even)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Reverse second half
        ListNode head2 = reverse(slow.next);
        slow.next = null; // split

        // 3) Merge two halves: head (L0->L1->...) and head2 (reversed tail)
        ListNode p1 = head, p2 = head2;
        while (p2 != null) {
            ListNode n1 = p1.next, n2 = p2.next;
            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }
    }
}

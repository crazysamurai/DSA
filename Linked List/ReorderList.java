/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid = middle(head);
        ListNode rev = reverse(mid.next);
        mid.next = null;
        ListNode curr = head;
        while (rev != null) {
            ListNode tmp1 = curr.next;
            ListNode tmp2 = rev.next;
            curr.next = rev;
            rev.next = tmp1;
            curr = tmp1;
            rev = tmp2;
        }
    }

    public ListNode middle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = new ListNode();
        prev = null;
        ListNode curr = head, next = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
// https://leetcode.com/problems/reorder-list/description/
// Find middle -> reverse the list after middle -> merge the two lists
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, curr = dummy, next = dummy;
        int length = 0;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        while (length >= k) {
            length -= k;
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
        }
        return dummy.next;
    }
}

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// https://www.youtube.com/watch?v=Of0HPkk3JgI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=35
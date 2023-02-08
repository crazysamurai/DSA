class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;

        while (n >= 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return temp.next;
    }
}
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
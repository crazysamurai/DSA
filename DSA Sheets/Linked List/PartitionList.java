class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();

        ListNode point1 = head1;
        ListNode point2 = head2;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                head1.next = curr;
                head1 = head1.next;
            } else {
                head2.next = curr;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        head1.next = point2.next;
        head2.next = null;
        return point1.next;
    }
}
// https://leetcode.com/problems/partition-list/description/
// create two separate lists and then combine them
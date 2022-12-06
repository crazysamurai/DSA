//yt: https://www.youtube.com/watch?v=YE9ggKeHeK0
//lc: https://leetcode.com/problems/odd-even-linked-list
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode evenHead = head.next;
        ListNode even = head.next;
        ListNode odd = head;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
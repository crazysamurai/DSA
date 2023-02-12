class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);
        ListNode rev = reverse(mid);
        while (head != null && rev != null) {
            if (head.val != rev.val)
                return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head, next = curr;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// https://leetcode.com/problems/palindrome-linked-list/description/
// https://www.youtube.com/watch?v=-DtNInqFUXs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=37
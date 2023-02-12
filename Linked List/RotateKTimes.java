class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int l = 1;
        ListNode temp = head;
        while (temp.next != null) {
            l++;
            temp = temp.next;
        }
        temp.next = head; // make the list cyclic
        k = k % l;
        k = l - k;

        while (k > 0) {
            temp = temp.next;
            k--;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }
}
// https://leetcode.com/problems/rotate-list/description/
// https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=40
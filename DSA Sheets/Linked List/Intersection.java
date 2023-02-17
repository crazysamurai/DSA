/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        int l1 = 0, l2 = 0;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                n1 = n1.next;
                l1++;
            }
            if (n2 != null) {
                n2 = n2.next;
                l2++;
            }
        }

        int diff = Math.abs(l1 - l2);

        if (l1 >= l2) {
            n1 = headA;
            n2 = headB;
        } else {
            n2 = headA;
            n1 = headB;
        }

        while (diff > 0) {
            n1 = n1.next;
            diff--;
        }

        while (n1 != null && n2 != null) {
            if (n1 == n2)
                return n1;
            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }
}
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=33
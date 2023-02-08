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

// space O(n+m)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if (list1 == null) {
            dummy.next = list2;
        } else if (list2 == null) {
            dummy.next = list1;
        }

        return head.next;
    }
}
// https://leetcode.com/problems/merge-two-sorted-lists/description/

// Space O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode head = l1;
        while (l1 != null && l2 != null) {
            ListNode temp = null;
            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            if (l1 == null) {
                temp.next = l2;
            } else {
                temp.next = l2;
                ListNode swap = l1;
                l1 = l2;
                l2 = swap;
            }
        }
        return head;
    }
}

// https://www.youtube.com/watch?v=Xb4slcp1U38&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=4
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr!=null){
            while(curr.next!=null && curr.val == curr.next.val){ //while there are duplicates, this loop does the deletion and this is O(n) time comp because the first loop will not traverse all the nodes, it'll jump to the next node with different value.
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
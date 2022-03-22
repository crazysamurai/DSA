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
        //sorted list is given
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        itr.next = head;
        ListNode curr = head.next;
        
        
        while(curr!=null){
            Boolean flag = false;
            while(curr!=null && curr.val == itr.next.val){
                flag = true;
                curr = curr.next;
            }
            if(flag == true){
                itr.next = curr;
            }else itr = itr.next;
            
            if(curr!=null) curr = curr.next;
        }
        return dummy.next;
    }
}
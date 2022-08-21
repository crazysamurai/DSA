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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d1 = l1;
        ListNode d2 = l2;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int rem = 0;
        
        while(d1!=null || d2!=null || rem>0){
            int sum = 0;
            
            if(d1!=null){
                sum += d1.val;
                d1 = d1.next;
            }
            
            if(d2!=null){
                sum += d2.val;
                d2 = d2.next;
            }
            
            sum += rem;
            rem = sum/10;
            sum = sum%10;
                        
            ListNode next = new ListNode(sum);
            temp.next = next;
            temp = temp.next;
            
        }
        return ans.next;
    }
}
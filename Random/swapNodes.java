class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode curr = temp;
        while(curr.next!=null && curr.next.next!= null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return temp.next;
    }
}
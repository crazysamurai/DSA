public class Solution {
    public static Node removeLoop(Node head) {
        // Write your code here.
        if (head == null || head.next == null)
            return head;
        Node fast = head;
        Node slow = head;
        Node prev = new Node(-1);
        boolean flag = false;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (flag) {
            slow = head;
            while (slow != fast) {
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }
            prev.next = null;
        }
        return head;
    }

}
// https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049?leftPanelTab=1
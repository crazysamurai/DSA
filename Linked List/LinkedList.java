public class LinkedList {

    static class Node {
        int val;
        Node next;

        // constructor
        Node(int d) {
            val = d;
            next = null;
        }
    }

    public static void main(String args[]) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;

        insert(head);
        delete(head, head, head);
        traverse(head);
    }

    // insert mid
    public static void insert(Node head) {
        Node temp = new Node(30);
        temp.next = head.next;
        head.next = temp;
        // traverse(head);
        return;
    }

    public static void delete(Node position, Node node, Node head) {
        if (node == null || node.next == null)
            return;

        // delete head
        if (position == head) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            traverse(head);
            return;
        }

        // delete else
        if (node == position || node.next == position) {
            node.next = position.next;
            return;
        }
        delete(position, node.next, head);
    }

    public static void traverse(Node node) {
        if (node.next == null) {
            return;
        }
        System.out.println(node.val);
        traverse(node.next);
    }

}
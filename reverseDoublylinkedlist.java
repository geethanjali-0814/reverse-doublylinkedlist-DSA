class Doublylinkedlist {
    static Node head;

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
    public static Node reverse(Node curr) {
        if (curr == null)
            return null;
        Node temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;
        if (curr.prev == null) {
            return curr;
        }
     
        return reverse(curr.prev);
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
     
        head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original linked list:");
        printList(head);
        head = reverse(head);

        System.out.println("Reversed linked list:");
        printList(head);
    }
}
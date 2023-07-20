package src;

public class LinkedList1<T> {
    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

    }

    private Node head;

    private void revert1(Node currentNode, Node previousNode) {
        if (currentNode.next == null)
            head = currentNode;
        else
            revert1(currentNode.next, currentNode);
        currentNode.next = previousNode;
    }

    public void revert() {
        if (head != null && head.next != null) {
            Node temp = head;
            revert1(head.next, head);
            temp.next = null;
        }
    }

    public void print() {
        Node currentNode = head;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.print("]\n");
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node(value);
    }
}

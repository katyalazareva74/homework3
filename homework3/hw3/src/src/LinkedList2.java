package src;

public class LinkedList2<T extends Comparable<T>> {
    private class Node {
        T value;
        Node next;
        Node previous;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    public int size;

    public void revert3() {
        if (tail != null && tail.previous != null) {
            Node temp = tail;
            tail = head;
            head = temp;
            Node currentNode = temp;
            while (currentNode != null) {
                temp = currentNode.previous;
                currentNode.previous = currentNode.next;
                currentNode.next = temp;
                currentNode = temp;
            }
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
            head.previous = null;
            tail = head;
            tail.next = null;
            size = 1;
            return;
        } else {
            Node currentNode = tail;
            tail.next = new Node(value);
            tail = tail.next;
            tail.previous = currentNode;
            tail.next = null;
            size++;
        }
    }

    public Node findN(int index) {
        if (head == null)
            return null;
        if (index < 0 || index > size)
            return null;
        Node currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public T findv(int index) {
        return this.findN(index).value;
    }

    private void swap(int left, int right) {
        Node nodeleft = null, currentNode = head, noderight = null;
        if (left < 0 || left >= size || right < 0 || right >= size)
            return;
        if (left == right)
            return;
        for (int i = 0; currentNode != null; i++) {
            if (left == i)
                nodeleft = currentNode;
            if (right == i)
                noderight = currentNode;
            currentNode = currentNode.next;
        }
        T temp = nodeleft.value;
        nodeleft.value = noderight.value;
        noderight.value = temp;
    }

    private void qicksortLL2(int leftB, int rightB) {
        int leftM = leftB;
        int rightM = rightB;
        T pivot = findv((leftM + rightM) / 2);
        while (leftM <= rightM) {
            while (findv(leftM).compareTo(pivot) < 0)
                leftM++;
            while (findv(rightM).compareTo(pivot) > 0)
                rightM--;
            if (leftM <= rightM) {
                if (leftM < rightM)
                    swap(leftM, rightM);
                leftM++;
                rightM--;
            }
        }
        if (leftM < rightB)
            qicksortLL2(leftM, rightB);
        if (rightM > leftB)
            qicksortLL2(leftB, rightM);
    }

    public void qsort2() {
        qicksortLL2(0, size - 1);
    }
}

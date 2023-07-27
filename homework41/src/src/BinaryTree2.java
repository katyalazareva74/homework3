package src;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryTree2
 */
public class BinaryTree2<T extends Comparable<T>> {
    Node root;
    int size;

    enum Color {
        red, black
    }

    private class Node {
        Node left;
        Node right;
        T value;
        Color color;

        Node(T value) {
            this.value = value;
            this.color = Color.red;
        }
    }

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            size = 1;
            return true;
        }
        boolean result = addNode(root, value);
        root = rebalance(root);
        root.color = Color.black;
        return result;
    }

    private boolean addNode(Node node, T value) {
        if (node.value == value)
            return false;
        if (node.value.compareTo(value) > 0) {
            if (node.left == null) {
                node.left = new Node(value);
                size++;
                return true;
            }
            boolean result = addNode(node.left, value);
            node.left = rebalance(node.left);
            return result;
        }
        if (node.right == null) {
            node.right = new Node(value);
            size++;
            return true;
        }
        boolean result = addNode(node.right, value);
        node.right = rebalance(node.right);
        return result;
    }

    private Node findNode(Node currNode, T value) {
        if (currNode.value == value)
            return currNode;
        if (currNode.value.compareTo(value) > 0)
            return currNode = findNode(currNode.left, value);
        return currNode = findNode(currNode.right, value);
    }

    public Node find(T value) {
        return findNode(root, value);
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance = true;
        while (needRebalance) {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.red
                    && (result.left == null || result.left.color == Color.black)) {
                needRebalance = true;
                result = rightswap(result);
            }
            if (result.left != null && result.left.left != null
                    && result.left.color == Color.red && result.left.left.color == Color.red) {
                needRebalance = true;
                result = leftswap(result);
            }
            if (result.left != null && result.right != null
                    && result.left.color == Color.red && result.right.color == Color.red) {
                needRebalance = true;
                colorswap(result);
            }
        }
        return result;
    }

    private void colorswap(Node node) {
        node.color = Color.red;
        node.left.color = Color.black;
        node.right.color = Color.black;
    }

    private Node leftswap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.red;
        return left;
    }

    private Node rightswap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.red;
        return right;
    }

    public void print() {
        List<Node> curLine = new ArrayList<>();
        curLine.add(root);
        System.out.printf("%50s", "root ");
        System.out.print("\u001B[36m" + root.value + "\u001B[0m" + "\n");
        while (curLine.size() > 0) {
            List<Node> curLine1 = new ArrayList<>();
            System.out.printf("%45s", " ");
            for (Node node : curLine) {
                if (node.left != null) {
                    curLine1.add(node.left);
                    if (node.left.color == Color.red)
                        System.out.print("\u001B[31m" + "l " + node.left.value + "  " + "\u001B[0m");
                    else
                        System.out.print("\u001B[36m" + "l " + node.left.value + "  " + "\u001B[0m");
                }
                if (node.right != null) {
                    curLine1.add(node.right);
                    if (node.right.color == Color.red)
                        System.out.print("\u001B[31m" + "r " + node.right.value + "  " + "\u001B[0m");
                    else
                        System.out.print("\u001B[36m" + "r " + node.right.value + "  " + "\u001B[0m");
                }
                System.out.printf("%2s", "");
            }
            System.out.println("\n");
            curLine = curLine1;
        }
    }
}
package Github.Sorting;

import java.util.Arrays;

public class TreeSort {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int[] dataSorted;
    private int counter = 0;

    public int[] toSort(int[] data) {
        this.dataSorted = Arrays.copyOf(data, data.length);
        this.addNode(data[0]);
        // Adding loop
        for(var i = 1; i < data.length; i++) {
            this.addNode(data[i]);
        }
        // Sorting
        this.inOrder(root);
        return this.dataSorted;
    }

    // VISIT => LEFT, ROOT, RIGHT
    private void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        this.dataSorted[counter++] = node.value;
        inOrder(node.right);
    }

    private void addNode(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return;
        }
        this.insertNode(root, newNode);
    }

    private void insertNode(Node root, Node newNode) {
        if(newNode.value < root.value) {
            if(root.left == null) {
                root.left = newNode;
            } else {
                insertNode(root.left, newNode);
            }
        } else {
            if(root.right == null) {
                root.right = newNode;
            } else {
                insertNode(root.right, newNode);
            }
        }
    }
}

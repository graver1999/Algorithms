package by.bsu.binarytree.entity;

public class BinaryTree {
    private Node node;
    private int depth;

    public BinaryTree() {
    }

    public BinaryTree(Node node) {
        this.node = node;
    }

    public void add(int value) {
        if (node != null) {
            recurAdd(node, value);
        } else {
            node = new Node(value);
        }
    }


    private void recurAdd(Node current, int value) {
        if (current == null) {
            current = new Node(value);
        } else {
            if (value < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node(value));
                } else {
                    recurAdd(current.getLeft(), value);
                }
            } else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(new Node(value));
                } else {
                    recurAdd(current.getRight(), value);
                }
            }
        }
    }

    public int getDepth() {
        return maxDepth(node);
    }

    private int maxDepth(Node node) {
        if (node != null) {
            return Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight())) + 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "node=" + node +
                '}';
    }
}

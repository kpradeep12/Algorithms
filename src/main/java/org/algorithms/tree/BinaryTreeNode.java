package org.algorithms.tree;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int value) {
        this.left = new BinaryTreeNode(value);
        return this.left;
    }

    public BinaryTreeNode insertRight(int value) {
        this.right = new BinaryTreeNode(value);
        return this.right;
    }
}

package org.algorithms.tree;

public class BinarySearchTree {
    Node root;
    class Node {
        int value;
        Node right, left;
        Node(int value) {this.value = value;}
    }

    public void insert(int data) {
        if(root == null) root = new Node(data);
        else insertNode(root, data);
    }
    private void insertNode(Node node, int data) {
        if(data < node.value) {
            if(node.left != null) insertNode(node.left, data);
            else node.left = new Node(data);
        }
        
        if(data > node.value) {
            if(node.right != null) insertNode(node.right, data);
            else node.right = new Node(data);
        }
    }

    public void inOrder() {
        System.out.print("InOrder -> ");
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
    public void preOrder() {
        System.out.print("PreOrder -> ");
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.value+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder() {
        System.out.print("PostOrder -> ");
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value+ " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("BST");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(1);
        bst.insert(8);
        bst.insert(6);
        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
    }
}

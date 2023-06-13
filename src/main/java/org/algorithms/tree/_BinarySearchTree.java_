package org.algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import javax.sound.sampled.SourceDataLine;

public class BinarySearchTree {
    Node root;
    static class Node {
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
    public void deleteNode(int value) {
        this.deleteNode(root, value);
    }
    private Node deleteNode(Node root, int value) {
        if(root == null) return null;
        else if(value < root.value)
            root.left = deleteNode(root.left, value);
        else if(value > root.value)
            root.right = deleteNode(root.right, value);
        else {
            if(root.left != null && root.right != null) {
                Node temp = minimumElement(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }else if(root.left == null) {
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }else return null;
        }
        return root;
    }
    public int minimumElement() {
        return minimumElement(root).value;
    }
    private Node minimumElement(Node root) {
        if(root.left == null) return root;
        else return minimumElement(root.left);
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
    
    public void createMinimalBST(int[] array) {
        this.root = this.createMinimalBST(array, 0, array.length - 1);
    }
    //Problem 4.2 given a sorted array to create a binary search tree with minimal height
    private Node createMinimalBST(int[] array, int start, int end) {
        if(end < start) return null;
        int mid = (start + end)/2;
        Node node = new Node(array[mid]);
        node.left = createMinimalBST(array, start, mid - 1);
        node.right = createMinimalBST(array, mid + 1, end);
        return node;
    }
    public void levelOrderTraversal() {
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + ", ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
    }
    //Problem 4.3 create lists of depth on a 'Binary tree'
    public void createListsOfDepth() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        current.add(root);
        while(current.size() > 0) {
            result.add(current);
            LinkedList<Node> temp = current;
            current = new LinkedList<>();
            for(Node node: temp) {
                if(node.left != null) current.add(node.left);
                if(node.right != null) current.add(node.right);
            }
        }
        for(LinkedList<Node> list : result) {
            System.out.println();
            list.forEach(n -> System.out.print(n.value + " "));
        }
    }
    //Problem 4.4 Check if BT is balanced by height not more than 1 level
    public boolean isTreeBalanced() {
        return checkBalance(root) != Integer.MIN_VALUE;
    }
    private int checkBalance(Node node) {
        if(node == null) return -1;
    
        int leftHeight = checkBalance(node.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
        int rightHeight = checkBalance(node.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
    
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1) 
            return Integer.MIN_VALUE;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
    /*int[] array;
    int size;
    public boolean isValidBST() {
        array = new int[size];
        index = 0;
        checkBST(root, array);
        System.out.println(Arrays.toString(array));
        for(int i=1; i<array.length; i++) {
            if(array[i] <= array[i-1]) return false;
        }
        return true;
    }
    int index = 0;
    private void checkBST(Node node, int[] array) {
        if(node == null) return;
        checkBST(node.left, array);
        array[index++] = node.value;
        checkBST(node.right, array);
    }*/
    //Problem 4.5 check if a BT is BST
    public boolean isValidBST() {
        return checkBST(root);
    }
    Integer previousValue;
    private boolean checkBST(Node node) {
        if(node == null) return true;
        if(!checkBST(node.left)) return false;
    
        if(previousValue != null && previousValue >= node.value)
            return false;
    
        previousValue = node.value;
        if(!checkBST(node.right)) return false;
        
        return true;
    }
    public static void main(String[] args) {
        System.out.println("BST");
        BinarySearchTree bst = new BinarySearchTree();
        /*bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(1);
        bst.insert(8);
        bst.insert(6);
        bst.inOrder();*/
        //bst.preOrder();
        //bst.postOrder();
        //System.out.println(bst.minimumElement());
        //bst.deleteNode(3);
        //bst.inOrder();
        //bst.createMinimalBST(new int[] {2, 4, 8, 10, 15, 16, 19});
        //bst.inOrder();
        //bst.createListsOfDepth();
        //bst.size = 6;
        bst.root = new BinarySearchTree.Node(10);
        bst.root.left=new BinarySearchTree.Node(4);
        bst.root.right=new BinarySearchTree.Node(12);
        bst.root.right.right=new BinarySearchTree.Node(16);
        bst.root.left.left = new BinarySearchTree.Node(2);
        bst.root.left.left.left = new BinarySearchTree.Node(1);
        bst.root.left.left.left.left = new BinarySearchTree.Node(0);
        bst.inOrder();
        System.out.println(bst.isValidBST());

//        System.out.println(bst.isValidBST());
    }

    // try this problem: print Binary tree level wise
}

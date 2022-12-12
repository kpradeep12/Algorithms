package org.algorithms.linkedlist;

public class LinkedList {
    public static class Node {
        int data; Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    Node root;
    public void insert(int data){
        Node node = new Node(data);
        if(root == null) root = node;
        else {
            node.next = root;
            root = node;
        }
    }
    public void insertLast(int data) {
        Node node = new Node(data);
        if(root == null) {
            root = node;
            return;
        }
        Node temp = root;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}

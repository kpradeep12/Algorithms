package org.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListDS {
    public static class Node {
        public int data; 
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public Node root;
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
    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        Node temp = root;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        return Arrays.toString(list.toArray());
    }
}

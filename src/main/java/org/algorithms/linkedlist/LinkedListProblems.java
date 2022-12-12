package org.algorithms.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.algorithms.linkedlist.LinkedList.Node;

public class LinkedListProblems {
    public static Node reverseList(Node node) {
        if(node.next == null) return node;
        Node root = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return root;
    }
    public static boolean hasCycle(Node node) {
        Node fast = node; Node slow = node;
        while(fast != null & fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static LinkedList mergeLists(LinkedList list1, LinkedList list2){
        Node first = list1.root, second = list2.root;
        LinkedList result = new LinkedList();
        while(first != null && second != null) {
            if(first.data <= second.data) {
                result.insertLast(first.data); first = first.next;
            }else {
                result.insertLast(second.data); second = second.next;
            }            
        }
        while(first != null) {
            result.insertLast(first.data); first = first.next;
        }
        while(second != null) {
            result.insertLast(second.data); second = second.next;
        }
        return result;
    }
    public static LinkedList mergeAll(Node[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));
        pq.addAll(Arrays.asList(list));
        LinkedList result = new LinkedList();
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.next != null) pq.add(node.next);
            result.insertLast(node.data);
        }
        return result;
    }
    public static void print(Node node) {
        if(node == null) {
            return;
        }
        Node temp = node;
        while(temp != null) {
            System.out.printf("%d -> ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //LinkedList list = new LinkedList();
        //list.insertLast(1); list.insertLast(2); list.insertLast(4);
        //print(list.root);
        //Node result = reverseList(list.root);
        //print(result);
        //System.out.println(hasCycle(list.root));

        /*LinkedList list1 = new LinkedList();
        list1.insertLast(1); list1.insertLast(2); list1.insertLast(4);
        LinkedList list2 = new LinkedList();
        list2.insertLast(1); list2.insertLast(3); list2.insertLast(4);
        LinkedList result = mergeLists(list1, list2);
        print(result.root);*/

        LinkedList list1 = new LinkedList();
        list1.insertLast(1); list1.insertLast(4); list1.insertLast(5);
        LinkedList list2 = new LinkedList();
        list2.insertLast(1); list2.insertLast(3); list2.insertLast(4);
        LinkedList list3 = new LinkedList();
        list3.insertLast(2); list3.insertLast(6);
        Node[] lists = new Node[]{list1.root, list2.root, list3.root};
        print(mergeAll(lists).root);

    }
}

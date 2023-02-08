package org.algorithms.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

import org.algorithms.linkedlist.LinkedListDS;
import org.algorithms.linkedlist.LinkedListDS.Node;

public class HeapProblems {
    public static List<Integer> topFrequentElements(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Entry<Integer, Integer>> queue = 
        new PriorityQueue<>(Comparator.comparingInt(entry -> entry.getValue()));
        for(Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(Entry<Integer, Integer> entry: queue) {
            result.add(entry.getKey());
        }
        return result;
    }
public static LinkedListDS mergeSortedLists(LinkedListDS[] lists) {
    Queue<Integer> queue = new PriorityQueue<>((n1,n2)->n2-n1);
    for(LinkedListDS list: lists) {
        Node temp = list.root;
        while(temp != null) {
            queue.offer(temp.data);
            temp = temp.next;
        }
    }
    LinkedListDS result = new LinkedListDS();
    while(!queue.isEmpty()) {
        result.insert(queue.poll());
    }
    return result;
}
    public static void main(String[] args) {
        //topFrequentElements(new int[]{1,1,1,2,2,3,3,3,3,3}, 2);
        /*MedianFinder mf = new MedianFinder();
        System.out.println(mf.findMedian());
        mf.addNum(1);mf.addNum(2);mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);*/
        LinkedListDS list1 = new LinkedListDS();
        list1.insertLast(1);list1.insertLast(4);list1.insertLast(5);
        LinkedListDS list2 = new LinkedListDS();
        list2.insertLast(1);list2.insertLast(3);list2.insertLast(4);
        LinkedListDS list3 = new LinkedListDS();
        list1.insertLast(2);list1.insertLast(6);
        LinkedListDS result = mergeSortedLists(new LinkedListDS[]{list1, list2, list3});
        System.out.println(result.toString());
    }
}

class MedianFinder {
    Queue<Integer> maxHeap = new PriorityQueue<>((n1,n2) -> n2-n1);
    Queue<Integer> minHeap = new PriorityQueue<>();
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        else return ((minHeap.peek() + maxHeap.peek())/2.0);
    }
}

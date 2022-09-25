package org.algorithms.graph;

import java.util.LinkedList;

public class Graph {
    
    LinkedList[] list = null;
    Integer size;
    public Graph(Integer size) {
        list = new LinkedList[size];
        this.size = size;
        for(int i=0; i<size; i++) list[i] = new LinkedList<Integer>();
    }

    public void addNode(Integer source, Integer destination) {
        list[source].add(destination);
        list[destination].add(source);
    }

    public void print() {
        for(int i=0; i<size; i++) {
            System.out.print(i + " -> ");
            for(int j=0; j<list[i].size(); j++) System.out.println(list[i].get(j) + ", ");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addNode(0, 1);
        graph.addNode(0, 2);
        graph.addNode(2, 3);
        graph.print();
    }

}
 
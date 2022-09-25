package org.algorithms.graph;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Graph {
    
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Integer size;
    Boolean isDirected;
    public Graph(Integer size, Boolean isDirected) {
        this.size = size;
        this.isDirected = isDirected;
        IntStream.range(0, size)
            .forEach(n -> list.add(n, new ArrayList<>()));
    }

    public void addNode(Integer source, Integer destination) {
        list.get(source).add(destination);
        if(!isDirected)
            list.get(destination).add(source);
    }

    public void print() {
        IntStream.range(0, size)
            .forEach(index -> {
                System.out.print(index + " -> ");
                list.get(index).forEach(vertex -> System.out.print(vertex + ", "));
                System.out.println();
            });
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4, true);
        graph.addNode(0, 1);
        graph.addNode(0, 2);
        graph.addNode(2, 3);
        graph.print();
    }

}
 
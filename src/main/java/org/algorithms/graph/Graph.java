package org.algorithms.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.IntStream;

public class Graph {
    
    ArrayList<LinkedList<Integer>> list = new ArrayList<>();
    boolean isDirectedGraph = false;

    public Graph(int size, boolean isDirectedGraph) {
        IntStream.range(0, size).forEach(n -> list.add(n, new LinkedList<>()));
        this.isDirectedGraph = isDirectedGraph;
    }

    void addNode(int source, int destination) {
        list.get(source).add(destination);
        if(!isDirectedGraph) list.get(destination).add(source);
    }

    void print() {
        for(int i=0; i<list.size(); i++) {
            System.out.print(i + " -> ");
            for(Integer num: list.get(i)) {
                System.out.print(num + " , ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        final Graph graph = (Graph) obj;
        if(this.list.size() != graph.list.size()) return false;
        for(int i=0; i<list.size(); i++) {
            if(!list.get(i).containsAll(graph.list.get(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(10, false);
        graph.addNode(0, 1); graph.addNode(0, 2); graph.addNode(0, 3);
        graph.addNode(1, 4);graph.addNode(2, 5);graph.addNode(2, 6);graph.addNode(3, 7);
        graph.addNode(4, 8);graph.addNode(5, 9);
        graph.print();
    }

    /*
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

    public void bfs(Integer root) {
        Deque<Integer> queue = new LinkedList<>();
        boolean[] tracker = new boolean[list.size()];
        tracker[root] = true;
        queue.offer(root);
        while(!queue.isEmpty()) {
            Integer vertex = queue.poll();
            System.out.println("processing " + vertex);
            list.get(vertex).forEach(node -> {
                if(!tracker[node]) {
                    queue.offer(node);
                    tracker[node] = true;
                }
                
            });
            
        }
    }

    public void dfs(Integer root) {
        Stack<Integer> stack = new Stack<>();
        boolean[] tracker = new boolean[list.size()];
        stack.push(root);
        tracker[root] = true;

        while(!stack.isEmpty()) {
            Integer node = stack.pop();
            System.out.println("procesing :" + node);
            list.get(node).forEach(n -> {
                if(!tracker[n]) {
                    stack.push(n);
                    tracker[n] = true;
                }
            });
        }

    }

    //Problem: 1 -> Route between nodes
    public boolean isConnected(Integer source, Integer destination) {
        if(source == destination) return true;
        Deque<Integer> queue = new LinkedList<>();
        boolean[] tracker = new boolean[list.size()];
        queue.offer(source);
        tracker[source] = true;
        while(!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for(Integer node: list.get(vertex)) {
                if(!tracker[node]) {
                    if(destination == node) {
                        return true;
                    }else {
                        queue.offer(node);
                        tracker[node] = true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(8, false);
        graph.addNode(0, 1);
        graph.addNode(1, 4);
        graph.addNode(1, 5);
        graph.addNode(4, 2);
        graph.addNode(5, 2);
        graph.addNode(2, 3);
        graph.addNode(3, 6);
        graph.addNode(5, 6);
        graph.print();
        //graph.dfs(0);
        System.out.println(graph.isConnected(2, 3));
    }*/

}
 
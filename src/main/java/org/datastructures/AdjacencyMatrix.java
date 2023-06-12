package org.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyMatrix {
    public ArrayList<List<Integer>> nodes = new ArrayList<>();
    public boolean isDirected;
    public AdjacencyMatrix(int size, boolean isDirected) {
        for(int i=0; i<size; i++) {
            nodes.add(new LinkedList<>());
        }
        this.isDirected = isDirected;
    }

    public void addEdge(int source, int destination) {
        nodes.get(source).add(destination);
        if(!isDirected) nodes.get(destination).add(source);
    }

    public AdjacencyMatrix edge(int source, int destination) {
        nodes.get(source).add(destination);
        if(!isDirected) nodes.get(destination).add(source);
        return this;
    }

    public void print() {
        for(int i=0; i<nodes.size(); i++) {
            System.out.print(i + " -> ");
            for(Integer num: nodes.get(i)) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
    
    public boolean equals(ArrayList<List<Integer>> list) {
        if(list == null) return false;
        if(list.size() != this.nodes.size()) return false;
        for(int i=0; i<this.nodes.size(); i++) {
            if(!this.nodes.get(i).containsAll(list.get(i))) return false;
        }
        return true;
    }
    
}
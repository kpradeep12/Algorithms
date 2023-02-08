package org.algorithms.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problems {
    /*
     * Traverse given graph using Breadth First Search approach
     * Input: Graph and root node
     * Output: List of nodes traversed
     */
    public static List<Integer> breadthFirstSearchTraversal(Graph graph, int root) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] vertices = new boolean[graph.list.size()];
        queue.offer(root);
        result.add(root);
        vertices[root] = true;
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = graph.list.get(queue.poll());
            for(int i=0; i<list.size(); i++) {
                Integer node = list.get(i);
                if(vertices[node] == false) {
                    queue.offer(node);
                    vertices[node] = true;
                    result.add(node);
                }
            }
        }
        return result;
    }
}

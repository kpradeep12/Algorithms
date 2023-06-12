package org.algorithms.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.datastructures.AdjacencyMatrix;

public class Problems {
    
    public static List<Integer> traverseGraphWithBFS(int root, AdjacencyMatrix am) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[am.nodes.size()];
        queue.offer(root);
        result.add(root);
        visited[root] = true;
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> list = am.nodes.get(node);
            for(Integer i : list) {
                if(!visited[i]) {
                    result.add(i);
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }


    /*
     * Traverse given graph using Breadth First Search
     * Input: Graph and root node
     * Output: List of nodes traversed
     */
    /*public static List<Integer> breadthFirstSearchTraversal(Graph graph, int root) {
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
    }*/

    /*
     * Traverse given graph using Depth First Search
     * Input: Graph and root node
     * Output: List of nodes traversed
     */
    public static List<Integer> depthFirstSearchTraversal(Graph graph, int root) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[graph.list.size()];
        stack.add(root);
        while(!stack.isEmpty()) {
            Integer node = stack.pop();
            if(!visited[node]) {
                visited[node] = true;
                result.add(node);
                List<Integer> list = graph.list.get(node);
                for(Integer num: list) {
                    if(!visited[num]) {
                        stack.push(num);
                    }
                }
            }
        }
        return result;
    }

    /*
     * Check if given start and end nodes are connected in the given directed graph
     * Input: Graph, start and end node
     * Output: boolean if connected, else false
     */
    public static boolean isRouteAvailable(Graph graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.list.size()];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            for(Integer num: graph.list.get(queue.poll())) {
                if(!visited[num]) {
                    if(num == end) return true;
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }
        return false;
    }

}

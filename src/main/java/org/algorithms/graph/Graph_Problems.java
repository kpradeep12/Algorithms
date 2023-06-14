package org.algorithms.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph_Problems {
    
    /*
     * Traverse given graph using Breadth First Search
     * Input: Graph and root node
     * Output: List of nodes traversed
     */
    public static List<Integer> traverseGraphWithBFS(int root, AdjacencyMatrix am) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[am.nodes.size()];
        queue.offer(root);
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            if(!visited[node]) {
                visited[node] = true;
                result.add(node);
                List<Integer> list = am.nodes.get(node);
                for(Integer i : list) {
                    if(!visited[i]) {
                        queue.offer(i);
                    }
                }
            }
        }
        return result;
    }

    /*
     * Traverse given graph using Depth First Search
     * Input: Graph and root node
     * Output: List of nodes traversed
     */
    public static List<Integer> traverseGraphWithDFS(int root, AdjacencyMatrix am) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[am.nodes.size()];
        stack.push(root);
        while(!stack.isEmpty()) {
            Integer node = stack.pop();
            if(!visited[node]) {
                visited[node] = true;
                result.add(node);
                List<Integer> list = am.nodes.get(node);
                for(Integer i : list) {
                    if(!visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        return result;
    }

    public static List<Integer> traveseGraphWithDFSRecursive(int root, AdjacencyMatrix am) {
        List<Integer> result = new LinkedList<>();
        dfsResurive(root, am, result, new boolean[am.nodes.size()]);
        return result;
    }
    private static void dfsResurive(int node, AdjacencyMatrix am, List<Integer> result, boolean[] visited) {
        if(!visited[node]) {
            visited[node] = true;
            result.add(node);
            for(Integer i: am.nodes.get(node)) {
                dfsResurive(i, am, result, visited);
            }
        }
    }
    
    

    /*
     * Check if given start and end nodes are connected in the given directed graph
     * Input: Graph, start and end node
     * Output: boolean if connected, else false
     */
    /*public static boolean isRouteAvailable(Graph graph, int start, int end) {
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
    }*/

}

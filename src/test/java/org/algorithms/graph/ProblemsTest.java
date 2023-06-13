package org.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.algorithms.*;
import org.junit.jupiter.api.Test;

public class ProblemsTest {
    @Test
    public void testBreadthFirstSearchTraversal() {
        AdjacencyMatrix am = new AdjacencyMatrix(10, false);
        am.addEdge(0, 1);am.addEdge(0, 2);am.addEdge(0, 3);
        am.addEdge(1, 4);am.addEdge(2, 5);am.addEdge(2, 6);
        am.addEdge(3, 7);
        am.addEdge(4, 8);am.addEdge(5, 9);
        List<Integer> result = Graph_Problems.traverseGraphWithBFS(0, am);
        assertTrue(Utils.compareListsWithOrder(result, List.of(0,1,2,3,4,5,6,7,8,9)));

        AdjacencyMatrix am2 = new AdjacencyMatrix(5, false);
        am2.addEdge(0, 1);am2.addEdge(0, 4);
        am2.addEdge(1, 0);am2.addEdge(1, 2);am2.addEdge(1, 4);am2.addEdge(1, 3);
        am2.addEdge(2, 1);am2.addEdge(2, 3);
        am2.addEdge(3, 4);am2.addEdge(3, 1);am2.addEdge(3, 2);
        am2.addEdge(4, 0);am2.addEdge(4, 1);am2.addEdge(4, 3);
        List<Integer> result2 = Graph_Problems.traverseGraphWithBFS(0, am2);
        assertTrue(Utils.compareListsWithOrder(result2, List.of(0,1,4,2,3)));
    }

    @Test
    void testTraverseGraphWithDFS() {
        AdjacencyMatrix am = new AdjacencyMatrix(10, false);
        am.addEdge(0, 1);am.addEdge(0, 2);am.addEdge(0, 3);
        am.addEdge(1, 4);am.addEdge(2, 5);am.addEdge(2, 6);
        am.addEdge(3, 7);
        am.addEdge(4, 8);am.addEdge(5, 9);
        List<Integer> result = Graph_Problems.traverseGraphWithDFS(0, am);
        result.forEach(System.out::println);
        assertTrue(Utils.compareListsWithOrder(result, List.of(0,3,7,2,6,5,9,1,4,8)));
    }

    @Test
    public void testDirectedGraphWithBreadthFirstSearchTraversal() {
        AdjacencyMatrix am = new AdjacencyMatrix(10, true);
        am.addEdge(0, 1);am.addEdge(0, 2);am.addEdge(0, 3);
        am.addEdge(1, 4);am.addEdge(2, 5);am.addEdge(2, 6);
        am.addEdge(3, 7);
        am.addEdge(4, 8);am.addEdge(5, 9);
        List<Integer> result = Graph_Problems.traverseGraphWithBFS(0, am);
        assertTrue(Utils.compareListsWithOrder(result, List.of(0,1,2,3,4,5,6,7,8,9)));
    }

    /*@Test
    public void testDepthFirstSearchTraversal() {
        Graph g1 = new Graph(10, false);
        g1.addNode(0, 1); g1.addNode(0, 2); g1.addNode(0, 3);
        g1.addNode(1, 4);g1.addNode(2, 5);g1.addNode(2, 6);g1.addNode(3, 7);
        g1.addNode(4, 8);g1.addNode(5, 9);
        List<Integer> result = Problems.depthFirstSearchTraversal(g1, 0);
        assertTrue(Utils.compareListsWithOrder(result, List.of(0,3,7,2,6,5,9,1,4,8)));
    }

    @Test
    public void testIsRouteAvailable() {
        Graph g1 = new Graph(5, true);
        g1.addNode(2, 0); g1.addNode(2, 3);g1.addNode(0, 2);g1.addNode(0, 1);
        g1.addNode(1, 2);g1.addNode(3, 3);g1.addNode(1, 4);
        assertTrue(Graph_Problems.isRouteAvailable(g1, 0, 4));
        assertTrue(Graph_Problems.isRouteAvailable(g1, 0, 3));
        assertFalse(Graph_Problems.isRouteAvailable(g1, 4, 3));
    }*/

    
}

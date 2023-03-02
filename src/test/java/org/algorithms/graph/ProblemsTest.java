package org.algorithms.graph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.algorithms.Utils;
import org.junit.Test;

public class ProblemsTest {
    @Test
    public void testBreadthFirstSearchTraversal() {
        Graph g1 = new Graph(10, false);
        g1.addNode(0, 1); g1.addNode(0, 2); g1.addNode(0, 3);
        g1.addNode(1, 4);g1.addNode(2, 5);g1.addNode(2, 6);g1.addNode(3, 7);
        g1.addNode(4, 8);g1.addNode(5, 9);
        List<Integer> result = Problems.breadthFirstSearchTraversal(g1, 0);
        assertTrue(Utils.compareListsWithOrder(result, List.of(0,1,2,3,4,5,6,7,8,9)));
    }

    @Test
    public void testDirectedGraphWithBreadthFirstSearchTraversal() {
        Graph g1 = new Graph(5, false);
        g1.addNode(2, 0); g1.addNode(2, 3);
        g1.addNode(0, 2);g1.addNode(0, 1);
        g1.addNode(1, 2);g1.addNode(3, 3);g1.addNode(1, 4);
        List<Integer> result = Problems.breadthFirstSearchTraversal(g1, 2);
        assertTrue(Utils.compareListsWithOrder(result, List.of(2,0,3,1,4)));
    }

    @Test
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
        assertTrue(Problems.isRouteAvailable(g1, 0, 4));
        assertTrue(Problems.isRouteAvailable(g1, 0, 3));
        assertFalse(Problems.isRouteAvailable(g1, 4, 3));
    }
}

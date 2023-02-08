package org.algorithms.graph;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ProblemsTest {
    @Test
    public void testTraverse() {
        Graph g1 = new Graph(10, false);
        g1.addNode(0, 1); g1.addNode(0, 2); g1.addNode(0, 3);
        g1.addNode(1, 4);g1.addNode(2, 5);g1.addNode(2, 6);g1.addNode(3, 7);
        g1.addNode(4, 8);g1.addNode(5, 9);
        List<Integer> result = Problems.breadthFirstSearchTraversal(g1, 0);
        System.out.println(result);
        assertTrue(result.containsAll(List.of(0,1,2,3,4,5,6,7,8,9)));
    }
}

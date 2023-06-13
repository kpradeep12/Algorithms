package org.algorithms.graph;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    public void graphTest() {
        // Undirect graph
        Graph g1 = new Graph(10, false);
        g1.addNode(0, 1); g1.addNode(0, 2); g1.addNode(0, 3);
        g1.addNode(1, 4);g1.addNode(2, 5);g1.addNode(2, 6);g1.addNode(3, 7);
        g1.addNode(4, 8);g1.addNode(5, 9);
        g1.print();
        Graph g2 = new Graph(10, false);
        g2.addNode(0, 1); g2.addNode(0, 2); g2.addNode(0, 3);
        g2.addNode(1, 4);g2.addNode(2, 5);g2.addNode(2, 6);g2.addNode(3, 7);
        g2.addNode(4, 8);g2.addNode(5, 9);
        assertEquals(g1, g2);

        //Directed graph
        Graph g3 = new Graph(10, true);
        g3.addNode(0, 1); g3.addNode(0, 2); g3.addNode(0, 3);
        g3.addNode(1, 4);g3.addNode(2, 5);g3.addNode(2, 6);g3.addNode(3, 7);
        g3.addNode(4, 8);g3.addNode(5, 9);
        Graph g4 = new Graph(10, true);
        g4.addNode(0, 1); g4.addNode(0, 2); g4.addNode(0, 3);
        g4.addNode(1, 4);g4.addNode(2, 5);g4.addNode(2, 6);g4.addNode(3, 7);
        g4.addNode(4, 8);g4.addNode(5, 9);
        assertEquals(g3, g4);
        
        assertNotEquals(g3, null);
        assertNotEquals(g3, new Graph(0, false));
        assertEquals(new Graph(0, false), new Graph(0, false));
    }
}

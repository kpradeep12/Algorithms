package org.datastructures;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdjacencyMatrixTest {
    @Test
    void testEquals() {
        AdjacencyMatrix am = new AdjacencyMatrix(10, false);
        am.addEdge(0, 1);am.addEdge(0, 2);am.addEdge(0, 3);
        am.addEdge(1, 4);am.addEdge(2, 5);am.addEdge(2, 6);
        am.addEdge(3, 7);
        am.addEdge(4, 8);am.addEdge(5, 9);

        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1,2,3));
        list.add(List.of(0,4));
        list.add(List.of(0,5,6));
        list.add(List.of(0,7));
        list.add(List.of(1,8));
        list.add(List.of(2,9));
        list.add(List.of(2));
        list.add(List.of(3));
        list.add(List.of(4));
        list.add(List.of(5));
        Assertions.assertTrue(am.equals(list));

        AdjacencyMatrix am2 = new AdjacencyMatrix(5, false);
        am2.edge(0,1).edge(0,4)
        .edge(1, 0).edge(1, 4).edge(1, 3).edge(1, 2)
        .edge(2, 1)
        .edge(3, 1).edge(3, 4)
        .edge(4, 0).edge(4, 1).edge(4, 3);
        ArrayList<List<Integer>> list2 = new ArrayList<>();
        list2.addAll(List.of(1,4), List.of(0,2,3,4), List.of(1), List.of(1,4),
        List.of(0,1,3));
        Arrays.
        Assertions.assertTrue(am2.equals(list2));
    }

    @Test
    void testDirectedGraphEquals() {
        AdjacencyMatrix am = new AdjacencyMatrix(10, true);
        am.addEdge(0, 1);am.addEdge(0, 2);am.addEdge(0, 3);
        am.addEdge(1, 4);am.addEdge(2, 5);am.addEdge(2, 6);
        am.addEdge(3, 7);
        am.addEdge(4, 8);am.addEdge(5, 9);

        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1,2,3));
        list.add(List.of(4));
        list.add(List.of(5,6));
        list.add(List.of(7));
        list.add(List.of(8));
        list.add(List.of(9));
        list.add(List.of());
        list.add(List.of());
        list.add(List.of());
        list.add(List.of());
        Assertions.assertTrue(am.equals(list));
    }
}

package org.algorithms.dynamic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DynamicProblemsTest {
    @Test
    public void testFibonacciOf() {
        assertEquals(0, DynamicProblems.fibonacciOf(0));
        assertEquals(1, DynamicProblems.fibonacciOf(1));
        assertEquals(1, DynamicProblems.fibonacciOf(2));
        assertEquals(2, DynamicProblems.fibonacciOf(3));
        assertEquals(8, DynamicProblems.fibonacciOf(6));
    }
}

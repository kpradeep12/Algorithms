package org.algorithms.dynamic;

import static org.algorithms.dynamic.DynamicProblems.fibonacciOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DynamicProblemsTest {
    @Test
    public void testFibonacciOf() {
        assertEquals(0, fibonacciOf(0));
        assertEquals(1, fibonacciOf(1));
        assertEquals(1, fibonacciOf(2));
        assertEquals(2, fibonacciOf(3));
        assertEquals(8, fibonacciOf(6));
    }
}

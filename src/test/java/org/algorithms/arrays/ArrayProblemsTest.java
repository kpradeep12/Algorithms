package org.algorithms.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayProblemsTest {
    @Test
    void testTwoSum() {
        assertArrayEquals(ArrayProblems.twoSum(new int[] {2,7,11,10}, 9), new int[]{0,1});
    }
}

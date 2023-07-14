package org.algorithms.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayProblemsTest {
    @Test
    void testTwoSum() {
        assertArrayEquals(ArrayProblems.twoSum(new int[] {2,7,11,10}, 9), new int[]{0,1});
        assertArrayEquals(ArrayProblems.twoSum(new int[] {2,8,11,10}, 9), null);
        assertArrayEquals(ArrayProblems.twoSum(new int[] {3,2,4}, 6), new int[]{1,2});
        assertArrayEquals(ArrayProblems.twoSum(new int[] {3,3}, 6), new int[]{0,1});
    }
}

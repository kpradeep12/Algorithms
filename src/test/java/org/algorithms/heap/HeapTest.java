package org.algorithms.heap;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;

public class HeapTest {
    @Test
   public void testTopFrequentElements(){
     assertThat(HeapProblems.topFrequentElements(new int[]{1,1,1,2,2,3}, 2))
     .hasSize(2).hasSameElementsAs(List.of(1,2));
     assertThat(HeapProblems.topFrequentElements(new int[]{1,1,1,2,2,3,3,3,3}, 3))
     .hasSize(3).hasSameElementsAs(List.of(1,3,2));
   }
}

package org.algorithms.linkedlist;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LinkedListProblemsTest {
    @Test
    public void testRemoveNthNodeFromLast() {
        LinkedListDS list1 = new LinkedListDS();
        list1.insertLast(1); list1.insertLast(2); list1.insertLast(3);
        list1.insertLast(4); list1.insertLast(5);
        assertEquals(Arrays.toString(List.of(1,2,3,5).toArray()), 
        LinkedListProblems.removeNthNodeFromLast(list1, 2).toString());
        list1 = new LinkedListDS();
        list1.insertLast(1); list1.insertLast(2); list1.insertLast(3);
        list1.insertLast(4); list1.insertLast(5);
        assertEquals(Arrays.toString(List.of(2,3,4,5).toArray()), 
        LinkedListProblems.removeNthNodeFromLast(list1, 5).toString());
    }
}

package org.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.algorithms.Utils;
import org.junit.jupiter.api.Test;

public class BinaryTree_ProblemsTest {

    BinaryTreeNode getTree1() {
        BinaryTreeNode bt = new BinaryTreeNode(2);
        bt.left = new BinaryTreeNode(7);
        bt.left.left = new BinaryTreeNode(1);
        bt.left.right = new BinaryTreeNode(6);
        bt.left.right.left = new BinaryTreeNode(3);
        bt.left.right.right = new BinaryTreeNode(11);

        bt.right = new BinaryTreeNode(5);
        bt.right.right = new BinaryTreeNode(9);
        bt.right.right.left = new BinaryTreeNode(4);
        return bt;
    }

    @Test
    void testInOrderTraversal() {
        List<Integer> list = new LinkedList<>();
        BinaryTree_Problems.inOrderTraversal(getTree1(), list);
        assertTrue(Utils.compareListsWithOrder(list, List.of(1,7,3,6,11,2,5,4,9)));
    }

    @Test
    void testPreOrderTraversal() {
        List<Integer> list = new LinkedList<>();
        BinaryTree_Problems.preOrderTraversal(getTree1(), list);
        assertTrue(Utils.compareListsWithOrder(list, List.of(2,7,1,6,3,11,5,9,4)));
    }

    @Test
    void testPostOrderTraversal() {
        List<Integer> list = new LinkedList<>();
        BinaryTree_Problems.postOrderTraversal(getTree1(), list);
        assertTrue(Utils.compareListsWithOrder(list, List.of(1,3,11,6,7,4,9,5,2)));
    }
}

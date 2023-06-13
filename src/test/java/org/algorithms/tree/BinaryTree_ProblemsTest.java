package org.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.algorithms.Utils;
import org.datastructures.BinaryTreeNode;
import org.junit.jupiter.api.Test;

public class BinaryTree_ProblemsTest {
    @Test
    void testInOrderTraversal() {
        BinaryTreeNode bt = new BinaryTreeNode(2);
        bt.left = new BinaryTreeNode(7);
        bt.left.left = new BinaryTreeNode(2);
        bt.left.right = new BinaryTreeNode(6);
        bt.left.right.left = new BinaryTreeNode(5);
        bt.left.right.right = new BinaryTreeNode(11);

        bt.right = new BinaryTreeNode(5);
        bt.right.right = new BinaryTreeNode(9);
        bt.right.right.left = new BinaryTreeNode(4);
        List<Integer> list = new LinkedList<>();
        BinaryTree_Problems.inOrderTraversal(bt, list);
        assertTrue(Utils.compareListsWithOrder(list, List.of(2,7,5,6,11,2,5,4,9)));
    }

    @Test
    void testPreOrderTraversal() {
        BinaryTreeNode bt = new BinaryTreeNode(2);
        bt.left = new BinaryTreeNode(7);
        bt.left.left = new BinaryTreeNode(2);
        bt.left.right = new BinaryTreeNode(6);
        bt.left.right.left = new BinaryTreeNode(5);
        bt.left.right.right = new BinaryTreeNode(11);

        bt.right = new BinaryTreeNode(5);
        bt.right.right = new BinaryTreeNode(9);
        bt.right.right.left = new BinaryTreeNode(4);
        List<Integer> list = new LinkedList<>();
        BinaryTree_Problems.preOrderTraversal(bt, list);
        assertTrue(Utils.compareListsWithOrder(list, List.of(2,7,2,6,5,11,5,9,4)));
    }

    @Test
    void testPostOrderTraversal() {
        BinaryTreeNode bt = new BinaryTreeNode(2);
        bt.left = new BinaryTreeNode(7);
        bt.left.left = new BinaryTreeNode(2);
        bt.left.right = new BinaryTreeNode(6);
        bt.left.right.left = new BinaryTreeNode(5);
        bt.left.right.right = new BinaryTreeNode(11);

        bt.right = new BinaryTreeNode(5);
        bt.right.right = new BinaryTreeNode(9);
        bt.right.right.left = new BinaryTreeNode(4);
        List<Integer> list = new LinkedList<>();
        BinaryTree_Problems.postOrderTraversal(bt, list);
        assertTrue(Utils.compareListsWithOrder(list, List.of(2,5,11,6,7,4,9,5,2)));
    }
}

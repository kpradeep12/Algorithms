package org.algorithms.tree;

import java.util.List;

import org.datastructures.BinaryTreeNode;

public class BinaryTree_Problems {
    
    //Problem 1
    public static void inOrderTraversal(BinaryTreeNode node, List<Integer> result) {
        if(node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.value);
        inOrderTraversal(node.right, result);
    }

    //Problem 2
    public static void preOrderTraversal(BinaryTreeNode node, List<Integer> result) {
        if(node == null) return;
        result.add(node.value);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    //Problem 3
    public static void postOrderTraversal(BinaryTreeNode node, List<Integer> result) {
        if(node == null) return;
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.value);
    }
}

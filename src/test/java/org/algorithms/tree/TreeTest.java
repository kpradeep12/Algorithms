package org.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TreeTest 
{
   @Test
   public void testSubTree(){
     assertTrue(BinaryTree.isSubTree(new BinaryTree.Node(3, new BinaryTree.Node(4, new BinaryTree.Node(1), new BinaryTree.Node(2)), new BinaryTree.Node(5)),
        new BinaryTree.Node(4, new BinaryTree.Node(1), new BinaryTree.Node(2))));
     assertFalse(BinaryTree.isSubTree(new BinaryTree.Node(3, new BinaryTree.Node(4, new BinaryTree.Node(1), new BinaryTree.Node(2)), new BinaryTree.Node(5)),
        new BinaryTree.Node(4, new BinaryTree.Node(1), new BinaryTree.Node(3))));
   }
}

package org.algorithms.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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

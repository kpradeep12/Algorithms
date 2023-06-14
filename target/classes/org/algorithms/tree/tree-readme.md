# Tree 

## Data structure

[org.datastructures.BinaryTreeNode.java](BinaryTreeNode.java)
```
class BinaryTreeNode {
    int value;
    BinaryTreeNode left,right;
}
```
**Tree 1**

            2
           / \
          /   \
         /     \
        7       5
       / \       \
      1   6       9
         / \     / 
        3  11   4   


## Algorithms

Tree algorithm problems are available in [org.algorithms.tree.BinaryTree_Problems.java](BinaryTree_Problems.java)

---

## Problems

### 1. In Order Traversal
```
Traverse the left node (node.left)  
Visit the node  
Traverse the right node (node.right)
```
If we perform **In Order traversal** operation on **Tree 1**, then we get output as: 1,7,3,6,11,2,5,4,9

### 2. Pre Order Traversal
```
Visit the node  
Traverse the left node (node.left)  
Traverse the right node (node.right)
```
If we perform **Pre Order traversal** operation on **Tree 1**, then we get output as: 2,7,1,6,3,11,5,9,4

### 3. Post Order Traversal
```
Traverse the left node (node.left)  
Traverse the right node (node.right)
Visit the node  
```
If we perform **Pre Order traversal** operation on **Tree 1**, then we get output as: 1,3,11,6,7,4,9,5,**2**
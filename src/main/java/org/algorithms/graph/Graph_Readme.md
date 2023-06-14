# Graph 

## Data structure

[org.datastructures.AdjacencyMatrix.java](AdjacencyMatrix.java)
```
class AdjacencyMatrix {
    ArrayList<List<Integer>> nodes = new ArrayList<>();
    boolean isDirected;
}
```
**Graph 1**

            0 ----- 1 ----- 2
            |      /|
            |    /  |
            |  /    |
            |/      |
            4 ----- 3      

**Graph 2**

                    0
                    |
                    2 
                                
                   
## Algorithms

Graph problems are available in [org.algorithms.graph.Graph_Problems.java](Graph_Problems.java)

---

## Problems

### 1. Breadth First Search Traversal
```
Traverse the left node (node.left)  
Visit the node  
Traverse the right node (node.right)
```
If we perform **In Order traversal** operation on **Tree 1**, then we get output as: 1,7,3,6,11,2,5,4,9

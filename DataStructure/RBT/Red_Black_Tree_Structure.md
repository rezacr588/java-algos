
# Red-Black Tree Data Structure

## Basics of Red-Black Trees

### Nodes and Colors
- Each node has a value.
- Each node has a color (red or black).

### Properties
1. **Root Property**: The root is always black.
2. **Red Property**: Red nodes cannot have red children (no two red nodes can be adjacent).
3. **Black Property**: Every path from a node to its descendant leaves has the same number of black nodes.
4. **Leaf Property**: All leaves (NIL nodes) are black.

## Insertion and Balancing

### Process
1. Insert the node using standard binary search tree insertion.
2. Fix violations of Red-Black Tree properties through rotations and recoloring.

## Step-by-Step Insertion from 0 to 100

### Steps

#### Step 1
**Insert**: 0
- Insert 0 as the root and color it black.
- **Tree Visualization**:
  ```
  0B
  ```

#### Step 2
**Insert**: 1
- Insert 1 as the right child of 0 and color it red.
- **Tree Visualization**:
  ```
  0B
    \
     1R
  ```

#### Step 3
**Insert**: 2
- Insert 2 as the right child of 1 and color it red. This creates two consecutive red nodes, violating the Red Property.
- Perform a left rotation around 0 and recolor to fix the violation.
- **Tree Visualization**:
  ```
    1B
   /  \
  0R  2R
  ```

#### Step 4
**Insert**: 3
- Insert 3 as the right child of 2 and color it red.
- No violations occur.
- **Tree Visualization**:
  ```
    1B
   /  \
  0R  2B
        \
         3R
  ```

#### Step 5
**Insert**: 4
- Insert 4 as the right child of 3 and color it red. This creates two consecutive red nodes.
- Perform necessary rotations and recoloring.
- **Tree Visualization**:
  ```
      1B
     /  \
    0R  3B
        /  \
       2R  4R
  ```

### Further Insertions Summary

As you continue inserting nodes from 5 to 100, the tree maintains its balance through rotations and recoloring. The key steps involve:

1. **Insertion**: Insert the node as a red node following the binary search tree rules.
2. **Violation Fixing**: Check for violations of the Red-Black Tree properties and fix them through:
   - **Recoloring**: Changing the color of nodes to maintain properties.
   - **Rotations**: Performing left or right rotations to maintain balance.

Given the strict balance properties, a Red-Black Tree with nodes ranging from 0 to 100 will maintain a height close to \(O(\log n)\), where \(n\) is the number of nodes. This ensures efficient operations.

## Visualization of Tree Structure

### Conceptual Visualization

Here’s a conceptual visualization of a balanced Red-Black Tree with nodes from 0 to 100 (this is not the exact structure but gives an idea of how it balances):

```
                     50B
                   /     \
                25R       75R
               /   \     /   \
            12B   37B  62B  87B
           /  \   / \  / \  / \
          ... ... ... ... ... ...
```

Each subtree follows the Red-Black Tree properties, with black heights maintained and red nodes not forming consecutive pairs.

## Conclusion

Red-Black Trees dynamically adjust themselves during insertions and deletions to ensure the properties are maintained, which provides efficient search, insertion, and deletion operations. Understanding the balancing through rotations and recoloring is key to working with Red-Black Trees effectively.

---

By maintaining these properties, Red-Black Trees ensure that the longest path from the root to any leaf is no more than twice as long as the shortest path, providing a good balance between the strictness of AVL trees and the performance of simpler binary search trees.

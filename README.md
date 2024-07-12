# CS Algorithms and Data Structures to Master

## Data Structures:

1. **Arrays**:

   - A collection of elements identified by index or key.
   - Used for storing multiple items of the same type together.
2. **Linked Lists**:

   - A linear collection of elements, where each element points to the next.
   - Useful for dynamic memory allocation.
3. **Stacks**:

   - A collection of elements with Last In First Out (LIFO) access.
   - Used in function call management and expression evaluation.
4. **Queues**:

   - A collection of elements with First In First Out (FIFO) access.
   - Used in scheduling and buffering.
5. **Hash Tables**:

   - A data structure that maps keys to values using a hash function.
   - Used for efficient data retrieval.
6. **Trees**:

   - A hierarchical data structure with nodes connected by edges.
   - Types include Binary Trees, Binary Search Trees, AVL Trees, etc.
7. **Heaps**:

   - A special tree-based structure that satisfies the heap property.
   - Used in priority queues and heap sort.
8. **Graphs**:

   - A collection of nodes connected by edges.
   - Used in network analysis, pathfinding, and many algorithms.
9. **Tries**:

   - A tree-like data structure used for storing strings in a space-efficient manner.
   - Useful in search operations.
10. **Sets**:

    - A collection of unique elements.
    - Useful for membership testing and eliminating duplicates.
11. **Deque (Double-Ended Queue)**:

    - Allows insertion and deletion at both ends.
    - Useful for certain types of scheduling and buffering tasks.
12. **Suffix Tree/Array**:

    - Used for efficient substring searching and other string-related problems.
13. **Fenwick Tree (Binary Indexed Tree)**:

    - Used for efficiently updating elements and calculating prefix sums in a table of numbers.
14. **Segment Tree**:

    - Used for answering range queries over an array, such as range minimum, range maximum, and range sum queries.
15. **B-Trees and B+ Trees**:

    - Balanced tree data structures that maintain sorted data and allow for efficient insertion, deletion, and search operations.
    - Commonly used in databases and file systems.
16. **Treaps**:

    - A combination of a binary search tree and a heap to maintain a dynamic set of ordered elements.
17. **Skip Lists**:

    - A probabilistic data structure that allows fast search, insertion, and deletion operations.
18. **Persistent Data Structures**:

    - Data structures that preserve their previous versions after modifications.

## Algorithms:

1. **Bubble Sort**:

   - A simple comparison-based sorting algorithm.
   - Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
2. **Selection Sort**:

   - An in-place comparison-based sorting algorithm.
   - Divides the input list into two parts: a sorted sublist and an unsorted sublist, and repeatedly selects the smallest element from the unsorted sublist.
3. **Insertion Sort**:

   - Builds the final sorted array one item at a time.
   - Suitable for small data sets and mostly sorted arrays.
4. **Merge Sort**:

   - A divide-and-conquer algorithm that divides the array into halves, sorts them, and then merges the sorted halves.
5. **Quick Sort**:

   - A divide-and-conquer algorithm that selects a pivot and partitions the array into two subarrays based on the pivot, then recursively sorts the subarrays.
6. **Heap Sort**:

   - An efficient comparison-based sorting algorithm that builds a heap from the input data and repeatedly extracts the maximum element.
7. **Counting Sort**:

   - A non-comparison-based sorting algorithm that works well when the range of input values is known and not too large.
8. **Radix Sort**:

   - A non-comparison-based sorting algorithm that sorts numbers digit by digit.
9. **Linear Search**:

   - A simple search algorithm that checks every element in the list until the target value is found or the list ends.
10. **Binary Search**:

    - A search algorithm that finds the position of a target value within a sorted array by repeatedly dividing the search interval in half.
11. **Depth-First Search (DFS)**:

    - An algorithm for traversing or searching tree or graph data structures.
    - Starts at the root and explores as far as possible along each branch before backtracking.
12. **Breadth-First Search (BFS)**:

    - An algorithm for traversing or searching tree or graph data structures.
    - Starts at the root and explores all the neighboring nodes at the present depth before moving on to nodes at the next depth level.
13. **Knapsack Problem**:

    - A problem in combinatorial optimization.
    - Given a set of items, each with a weight and a value, determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible.
14. **Longest Common Subsequence**:

    - Finds the longest subsequence common to all sequences in a set of sequences.
    - Used in bioinformatics and text comparison.
15. **Dijkstra's Algorithm**:

    - An algorithm for finding the shortest paths between nodes in a graph.
    - Used in routing and navigation.
16. **Kruskal's Algorithm**:

    - An algorithm for finding the minimum spanning tree for a connected weighted graph.
    - Used in network design.
17. **Prim's Algorithm**:

    - Another algorithm for finding the minimum spanning tree for a connected weighted graph.
    - Greedy algorithm that builds the MST one edge at a time.
18. **N-Queens Problem**:

    - A backtracking problem to place N chess queens on an N×N chessboard so that no two queens threaten each other.
19. **Sudoku Solver**:

    - A backtracking algorithm to solve Sudoku puzzles by filling empty cells with digits without violating the rules of Sudoku.
20. **Floyd-Warshall Algorithm**:

    - A graph analysis algorithm for finding shortest paths in a weighted graph with positive or negative edge weights.
21. **Bellman-Ford Algorithm**:

    - An algorithm for finding shortest paths in a weighted graph.
    - Handles graphs with negative edge weights.
22. **KMP Algorithm**:

    - A string matching algorithm that searches for occurrences of a word within a main text string by employing the observation that when a mismatch occurs, the word itself embodies sufficient information to determine where the next match could begin.
23. **Rabin-Karp Algorithm**:

    - A string searching algorithm that uses hashing to find any one of a set of pattern strings in a text.
24. **Boyer-Moore Algorithm**:

    - An efficient string searching algorithm that skips sections of the text and reduces the number of comparisons needed.
25. **Bit Manipulation**:

    - Algorithms that use bitwise operations to solve problems.
    - Efficient for low-level programming and optimization tasks.
26. **Prime Numbers**:

    - Algorithms related to finding prime numbers, such as the Sieve of Eratosthenes.
27. **Greatest Common Divisor (GCD)**:

    - Algorithms to find the largest number that divides two or more numbers without leaving a remainder, such as the Euclidean algorithm.
28. **Least Common Multiple (LCM)**:

    - Algorithms to find the smallest number that is a multiple of two or more numbers.
29. **Dynamic Programming**:

    - Techniques for solving problems by breaking them down into simpler subproblems and solving each subproblem just once.
    - Examples include:
      - **Fibonacci Sequence**: Calculation using dynamic programming.
      - **Longest Increasing Subsequence**: Finding the longest subsequence where elements are in increasing order.
      - **Matrix Chain Multiplication**: Finding the most efficient way to multiply a given sequence of matrices.
30. **Greedy Algorithms**:

    - Strategies for making the locally optimal choice at each stage with the hope of finding the global optimum.
    - Examples include:
      - **Activity Selection Problem**: Selecting the maximum number of activities that don't overlap.
31. **Union-Find (Disjoint Set Union)**:

    - A data structure that keeps track of elements partitioned into disjoint (non-overlapping) sets.
    - Used in network connectivity and Kruskal's algorithm.
32. **Topological Sort**:

    - Ordering of vertices in a directed graph where for every directed edge UV, vertex U comes before V in the ordering.
    - Useful in scheduling tasks.
33. **A* Search Algorithm**:

    - An extension of Dijkstra's Algorithm that uses heuristics to find the shortest path more efficiently.
34. **Ford-Fulkerson Algorithm**:

    - Used for computing the maximum flow in a flow network.
35. **Boyer-Moore Majority Vote Algorithm**:

    - An algorithm to find the majority element in an array.
36. **Hopcroft-Karp Algorithm**:

    - Used to find the maximum matching in a bipartite graph.
37. **Tarjan's Algorithm**:

    - Used for finding strongly connected components in a graph.
38. **Manacher’s Algorithm**:

    - For finding the longest palindromic substring in linear time.
39. **Convex Hull Algorithms (e.g., Graham’s scan, Jarvis’s march)**:

    - For finding the smallest convex polygon that can enclose a set of points.
40. **String Matching Algorithms**:

    - Additional algorithms like Aho-Corasick for multiple pattern searching.

import java.util.*;

// Define the Graph class
class BFS {
  private int numVertices; // Number of vertices in the graph
  private LinkedList<Integer>[] adjList; // Adjacency list to store the graph

  // Constructor to initialize the graph
  public BFS(int numVertices) {
    this.numVertices = numVertices;
    adjList = new LinkedList[numVertices];
    for (int i = 0; i < numVertices; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  // Method to add an edge between two vertices
  public void addEdge(int src, int dest) {
    adjList[src].add(dest);
  }

  // Method to perform BFS traversal starting from a given vertex
  public void BFS(int startVertex) {
    boolean[] visited = new boolean[numVertices]; // Array to keep track of visited vertices
    LinkedList<Integer> queue = new LinkedList<>(); // Queue to manage the vertices to be explored

    // Mark the start vertex as visited and add it to the queue
    visited[startVertex] = true;
    queue.add(startVertex);

    // Loop until the queue is empty
    while (queue.size() != 0) {
      // Dequeue a vertex from the queue
      int currentVertex = queue.poll();
      System.out.print(currentVertex + " "); // Print the current vertex

      // Get all adjacent vertices of the dequeued vertex
      Iterator<Integer> iterator = adjList[currentVertex].listIterator();
      while (iterator.hasNext()) {
        int nextVertex = iterator.next();
        // If the adjacent vertex has not been visited, mark it as visited and enqueue
        // it
        if (!visited[nextVertex]) {
          visited[nextVertex] = true;
          queue.add(nextVertex);
        }
      }
    }
  }

  // Main method to test the BFS algorithm
  public static void main(String[] args) {
    BFS graph = new BFS(6); // Create a graph with 6 vertices

    // Add edges to the graph
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);

    // Define the Graph class
    // 0
    // / \
    // 1 2
    // / \ \
    // 3 4 5

    System.out.println("BFS traversal starting from vertex 0:");
    graph.BFS(0); // Perform BFS starting from vertex 0
  }
}

import java.util.LinkedList;

class DFS {
  private int numNodes;
  private LinkedList<Integer>[] adjList;

  // Constructor
  @SuppressWarnings("unchecked")
  public DFS(int numNodes) {
    this.numNodes = numNodes;
    adjList = new LinkedList[numNodes];
    for (int i = 0; i < numNodes; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  // Add edge to the graph
  public void addEdge(int src, int dest) {
    adjList[src].add(dest);
  }

  // Recursive DFS utility
  private void dfsRecursive(int node, boolean[] visited) {
    visited[node] = true;
    System.out.print(node + " ");

    for (int neighbor : adjList[node]) {
      if (!visited[neighbor]) {
        dfsRecursive(neighbor, visited);
      }
    }
  }

  // Public method to start DFS
  public void dfsRecursive(int startNode) {
    boolean[] visited = new boolean[numNodes];
    System.out.println("Depth-First Search (DFS) starting from node " + startNode + ":");
    dfsRecursive(startNode, visited);
    System.out.println();
  }

  // Iterative DFS using a stack
  public void dfsIterative(int startNode) {
    boolean[] visited = new boolean[numNodes];
    LinkedList<Integer> stack = new LinkedList<>();

    stack.push(startNode);

    System.out.println("Depth-First Search (DFS) starting from node " + startNode + ":");
    while (!stack.isEmpty()) {
      int node = stack.pop();

      if (!visited[node]) {
        System.out.print(node + " ");
        visited[node] = true;

        for (int neighbor : adjList[node]) {
          if (!visited[neighbor]) {
            stack.push(neighbor);
          }
        }
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int numNodes = 5; // Example number of nodes
    DFS graph = new DFS(numNodes);

    // Example edges
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);

    // Perform DFS
    graph.dfsRecursive(0);
    graph.dfsIterative(0);
  }
}

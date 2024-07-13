import java.util.LinkedList;

class Graph {
    private int numVertices;
    private LinkedList<Integer> adjList[];

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // For undirected graph
    }

    void removeEdge(int v, int w) {
        adjList[v].remove((Integer) w);
        adjList[w].remove((Integer) v); // For undirected graph
    }

    boolean hasEdge(int v, int w) {
        return adjList[v].contains(w);
    }

    void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Graph representation:");
        g.printGraph();

        System.out.println("Removing edge 1-4:");
        g.removeEdge(1, 4);
        g.printGraph();

        System.out.println("Edge between 0 and 4: " + g.hasEdge(0, 4));
        System.out.println("Edge between 1 and 4: " + g.hasEdge(1, 4));
    }
}

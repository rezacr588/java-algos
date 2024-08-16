class MinHeap {
    private int[] heap;  // Array to store heap elements
    private int size;    // Number of elements in the heap
    private int maxSize; // Maximum size of the heap

    // Constructor to initialize an empty heap with a maximum size
    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;  // Placeholder to simplify index calculations
    }

    // Method to get the position of the parent of a node
    private int parent(int pos) {
        return pos / 2;
    }

    // Method to get the position of the left child of a node
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Method to get the position of the right child of a node
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Method to check if a node is a leaf (no children)
    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    // Method to swap two nodes in the heap
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Method to insert an element into the heap
    public void insert(int element) {
        heap[++size] = element;  // Add the new element at the end of the array
        int current = size;

        // Move the new element up to its correct position
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method to remove and return the smallest element (the root) from the heap
    public int extractMin() {
        int popped = heap[1];  // The smallest element is always at the root
        heap[1] = heap[size--];  // Replace the root with the last element in the heap
        heapifyDown(1);  // Move the new root down to its correct position
        return popped;  // Return the smallest element that was removed
    }

    // Method to move a node down the heap to maintain the heap property
    private void heapifyDown(int pos) {
        if (!isLeaf(pos)) {  // If the node is not a leaf
            // If the current node is greater than either of its children
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                // Swap with the left child and heapify down the left child
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    heapifyDown(leftChild(pos));
                } else {
                    // Swap with the right child and heapify down the right child
                    swap(pos, rightChild(pos));
                    heapifyDown(rightChild(pos));
                }
            }
        }
    }

    // Method to get the smallest element without removing it
    public int getMin() {
        return heap[1];
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the number of elements in the heap
    public int size() {
        return size;
    }

    // Method to print the heap
    public void printHeap() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                " PARENT : " + heap[i]
                + " LEFT CHILD : " + heap[2 * i]
                + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Main method to test the Min-Heap implementation
    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");

        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.printHeap();  // Print the heap structure

        System.out.println("The Min val is " + minHeap.extractMin());  // Remove and print the smallest element
    }
}

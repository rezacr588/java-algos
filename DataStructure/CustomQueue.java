class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}

public class CustomQueue<T> {
  private Node<T> front;
  private Node<T> rear;
  private int size;

  public CustomQueue() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  // Add an element to the rear of the queue
  public void enqueue(T data) {
    Node<T> newNode = new Node<>(data);
    if (rear == null) {
      front = rear = newNode;
    } else {
      rear.next = newNode;
      rear = newNode;
    }
    size++;
  }

  // Remove an element from the front of the queue
  public T dequeue() {
    if (front == null) {
      throw new IllegalStateException("Queue is empty");
    }
    T data = front.data;
    front = front.next;
    if (front == null) {
      rear = null;
    }
    size--;
    return data;
  }

  // Peek at the front element without removing it
  public T peek() {
    if (front == null) {
      throw new IllegalStateException("Queue is empty");
    }
    return front.data;
  }

  // Check if the queue is empty
  public boolean isEmpty() {
    return front == null;
  }

  // Get the size of the queue
  public int size() {
    return size;
  }

  // Print the elements of the queue
  public void printQueue() {
    Node<T> current = front;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CustomQueue<Integer> queue = new CustomQueue<>();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    System.out.println("Queue: ");
    queue.printQueue();

    System.out.println("Front element: " + queue.peek());

    System.out.println("Dequeued element: " + queue.dequeue());

    System.out.println("Queue after dequeue: ");
    queue.printQueue();

    System.out.println("Queue size: " + queue.size());
  }
}

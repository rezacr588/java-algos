import java.util.EmptyStackException;

public class Stack<T> {
  private Node<T> top;
  private int size;

  // Node class for stack elements
  private static class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  // Constructor to initialize stack
  public Stack() {
    top = null;
    size = 0;
  }

  // Method to check if the stack is empty
  public boolean isEmpty() {
    return top == null;
  }

  // Method to push an element onto the stack
  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.next = top;
    top = newNode;
    size++;
  }

  // Method to pop an element from the stack
  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    T data = top.data;
    top = top.next;
    size--;
    return data;
  }

  // Method to peek at the top element of the stack
  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  // Method to get the size of the stack
  public int getSize() {
    return size;
  }

  // Method to display stack elements
  public void display() {
    Node<T> current = top;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  // Main method to demonstrate stack operations
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println("Stack after pushing 1, 2, 3:");
    stack.display();

    System.out.println("Top element is: " + stack.peek());

    System.out.println("Popped element is: " + stack.pop());

    System.out.println("Stack after popping an element:");
    stack.display();

    System.out.println("Size of stack: " + stack.getSize());
  }
}

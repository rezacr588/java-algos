public class SinglyLinkedList {
  private Node head;

  // Inner class to represent a node in the singly linked list
  private static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Constructor to initialize an empty list
  public SinglyLinkedList() {
    this.head = null;
  }

  // Method to add a new node at the end of the list
  public void add(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  // Method to add a new node at the beginning of the list
  public void addFirst(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  // Method to insert a new node at a specific position
  public void insertAt(int index, int data) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index cannot be negative");
    }
    if (index == 0) {
      addFirst(data);
      return;
    }
    Node newNode = new Node(data);
    Node current = head;
    for (int i = 0; i < index - 1; i++) {
      if (current == null) {
        throw new IndexOutOfBoundsException("Index out of bounds");
      }
      current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
  }

  // Method to delete a node with a specific value
  public void delete(int key) {
    Node current = head;
    Node previous = null;

    // If head node itself holds the key to be deleted
    if (current != null && current.data == key) {
      head = current.next; // Changed head
      return;
    }

    // Search for the key to be deleted
    while (current != null && current.data != key) {
      previous = current;
      current = current.next;
    }

    // If key was not present in the list
    if (current == null) {
      return;
    }

    // Unlink the node from the linked list
    previous.next = current.next;
  }

  // Method to delete a node at a specific position
  public void deleteAt(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index cannot be negative");
    }
    if (head == null) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (index == 0) {
      head = head.next;
      return;
    }
    Node current = head;
    for (int i = 0; i < index - 1; i++) {
      if (current.next == null) {
        throw new IndexOutOfBoundsException("Index out of bounds");
      }
      current = current.next;
    }
    if (current.next == null) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    current.next = current.next.next;
  }

  // Method to search for a node with a specific value
  public boolean search(int key) {
    Node current = head;
    while (current != null) {
      if (current.data == key) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Method to get the size of the linked list
  public int size() {
    int count = 0;
    Node current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  // Method to reverse the linked list
  public void reverse() {
    Node previous = null;
    Node current = head;
    Node next;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    head = previous;
  }

  // Method to print the linked list
  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  // Main method to demonstrate the usage of the singly linked list
  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.printList(); // Output: 1 -> 2 -> 3

    list.addFirst(0);
    list.printList(); // Output: 0 -> 1 -> 2 -> 3

    list.insertAt(2, 5);
    list.printList(); // Output: 0 -> 1 -> 5 -> 2 -> 3

    list.delete(2);
    list.printList(); // Output: 0 -> 1 -> 5 -> 3

    list.deleteAt(1);
    list.printList(); // Output: 0 -> 5 -> 3

    System.out.println("Size: " + list.size()); // Output: Size: 3

    list.reverse();
    list.printList(); // Output: 3 -> 5 -> 0

    System.out.println(list.search(5)); // Output: true
    System.out.println(list.search(10)); // Output: false
  }
}

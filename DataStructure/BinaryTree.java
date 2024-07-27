public class BinaryTree {
  Node root;

  // Constructor
  public BinaryTree() {
    root = null;
  }

  class Node {
    int value;
    Node left, right;

    public Node(int value) {
      this.value = value;
      left = right = null;
    }
  }

  // Insert a node into the binary tree
  void insert(int value) {
    root = insertRec(root, value);
  }

  Node insertRec(Node root, int value) {
    if (root == null) {
      root = new Node(value);
      return root;
    }
    if (value < root.value) {
      root.left = insertRec(root.left, value);
    } else if (value > root.value) {
      root.right = insertRec(root.right, value);
    }
    return root;
  }

  // Search a value in the binary tree
  boolean search(int value) {
    return searchRec(root, value) != null;
  }

  Node searchRec(Node root, int value) {
    if (root == null || root.value == value) {
      return root;
    }
    if (root.value > value) {
      return searchRec(root.left, value);
    }
    return searchRec(root.right, value);
  }

  // In-order traversal
  void inOrderTraversal() {
    inOrderRec(root);
  }

  void inOrderRec(Node root) {
    if (root != null) {
      inOrderRec(root.left);
      System.out.print(root.value + " ");
      inOrderRec(root.right);
    }
  }

  // Pre-order traversal
  void preOrderTraversal() {
    preOrderRec(root);
  }

  void preOrderRec(Node root) {
    if (root != null) {
      System.out.print(root.value + " ");
      preOrderRec(root.left);
      preOrderRec(root.right);
    }
  }

  // Post-order traversal
  void postOrderTraversal() {
    postOrderRec(root);
  }

  void postOrderRec(Node root) {
    if (root != null) {
      postOrderRec(root.left);
      postOrderRec(root.right);
      System.out.print(root.value + " ");
    }
  }

  // Main method to test the binary tree
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();

    // Insert nodes
    bt.insert(50);
    bt.insert(30);
    bt.insert(20);
    bt.insert(40);
    bt.insert(70);
    bt.insert(60);
    bt.insert(80);

    // Print in-order traversal
    System.out.println("In-order traversal:");
    bt.inOrderTraversal();

    // Print pre-order traversal
    System.out.println("\nPre-order traversal:");
    bt.preOrderTraversal();

    // Print post-order traversal
    System.out.println("\nPost-order traversal:");
    bt.postOrderTraversal();

    // Search for a value
    int valueToSearch = 40;
    boolean isFound = bt.search(valueToSearch);
    System.out.println("\nSearch for " + valueToSearch + ": " + (isFound ? "Found" : "Not Found"));
  }
}

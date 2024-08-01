class RedBlackTree {

  private static final boolean RED = true; // Constant to represent the color red
  private static final boolean BLACK = false; // Constant to represent the color black

  // Node class to represent each node in the Red-Black Tree
  private class Node {
    int data;
    Node left, right, parent;
    boolean color;

    // Constructor to create a new node
    Node(int data) {
      this.data = data;
      this.color = RED; // New nodes are always red initially
    }
  }

  private Node root = null; // Root of the Red-Black Tree

  // Method to insert a new node with the given data
  public void insert(int data) {
    Node newNode = new Node(data);
    if (root == null) {
      root = newNode;
      root.color = BLACK; // Root is always black
    } else {
      root = insert(root, newNode);
      fixInsertion(newNode);
    }
  }

  // Helper method to insert a node in the BST manner
  private Node insert(Node root, Node newNode) {
    if (root == null) {
      return newNode;
    }

    if (newNode.data < root.data) {
      root.left = insert(root.left, newNode);
      root.left.parent = root;
    } else if (newNode.data > root.data) {
      root.right = insert(root.right, newNode);
      root.right.parent = root;
    }

    return root;
  }

  // Method to fix the Red-Black Tree properties after insertion
  private void fixInsertion(Node node) {
    Node parent, grandParent;

    while (node != root && node.color == RED && node.parent.color == RED) {
      parent = node.parent;
      grandParent = parent.parent;

      // Case when parent is the left child of grandparent
      if (parent == grandParent.left) {
        Node uncle = grandParent.right;

        // Case when uncle is red (recoloring)
        if (uncle != null && uncle.color == RED) {
          grandParent.color = RED;
          parent.color = BLACK;
          uncle.color = BLACK;
          node = grandParent;
        } else {
          // Case when node is the right child (left rotation)
          if (node == parent.right) {
            rotateLeft(parent);
            node = parent;
            parent = node.parent;
          }

          // Case when node is the left child (right rotation)
          rotateRight(grandParent);
          boolean temp = parent.color;
          parent.color = grandParent.color;
          grandParent.color = temp;
          node = parent;
        }
      } else {
        // Case when parent is the right child of grandparent
        Node uncle = grandParent.left;

        // Case when uncle is red (recoloring)
        if (uncle != null && uncle.color == RED) {
          grandParent.color = RED;
          parent.color = BLACK;
          uncle.color = BLACK;
          node = grandParent;
        } else {
          // Case when node is the left child (right rotation)
          if (node == parent.left) {
            rotateRight(parent);
            node = parent;
            parent = node.parent;
          }

          // Case when node is the right child (left rotation)
          rotateLeft(grandParent);
          boolean temp = parent.color;
          parent.color = grandParent.color;
          grandParent.color = temp;
          node = parent;
        }
      }
    }

    root.color = BLACK; // Ensure the root is always black
  }

  // Method to perform a left rotation around a given node
  private void rotateLeft(Node node) {
    Node rightChild = node.right;
    node.right = rightChild.left;

    if (node.right != null) {
      node.right.parent = node;
    }

    rightChild.parent = node.parent;

    if (node.parent == null) {
      root = rightChild;
    } else if (node == node.parent.left) {
      node.parent.left = rightChild;
    } else {
      node.parent.right = rightChild;
    }

    rightChild.left = node;
    node.parent = rightChild;
  }

  // Method to perform a right rotation around a given node
  private void rotateRight(Node node) {
    Node leftChild = node.left;
    node.left = leftChild.right;

    if (node.left != null) {
      node.left.parent = node;
    }

    leftChild.parent = node.parent;

    if (node.parent == null) {
      root = leftChild;
    } else if (node == node.parent.left) {
      node.parent.left = leftChild;
    } else {
      node.parent.right = leftChild;
    }

    leftChild.right = node;
    node.parent = leftChild;
  }

  // Method to search for a node with given data
  public boolean search(int data) {
    return search(root, data);
  }

  // Helper method for searching a node
  private boolean search(Node root, int data) {
    if (root == null) {
      return false; // Node not found
    }

    if (data < root.data) {
      return search(root.left, data); // Search in the left subtree
    } else if (data > root.data) {
      return search(root.right, data); // Search in the right subtree
    } else {
      return true; // Node found
    }
  }

  // Method to perform an inorder traversal of the tree
  public void inorderTraversal() {
    inorderTraversal(root);
  }

  // Helper method for inorder traversal
  private void inorderTraversal(Node root) {
    if (root != null) {
      inorderTraversal(root.left);
      System.out.print(root.data + " ");
      inorderTraversal(root.right);
    }
  }

  // Main method for testing the Red-Black Tree
  public static void main(String[] args) {
    RedBlackTree tree = new RedBlackTree();

    // Insert nodes into the tree
    int[] values = { 20, 15, 25, 10, 5, 1, 30 };
    for (int value : values) {
      tree.insert(value);
    }

    // Perform an inorder traversal of the tree
    System.out.println("Inorder traversal of the Red-Black Tree:");
    tree.inorderTraversal();
    System.out.println();

    // Search for a node in the tree
    int searchValue = 15;
    System.out.println("Searching for " + searchValue + ": " + tree.search(searchValue));
  }
}

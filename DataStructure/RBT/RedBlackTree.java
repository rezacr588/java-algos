class Node {
  int data;
  Node parent;
  Node left;
  Node right;
  boolean color; // true for Red, false for Black

  Node(int data) {
    this.data = data;
    this.parent = null;
    this.left = null;
    this.right = null;
    this.color = true; // New nodes are typically red
  }
}

class RedBlackTree {
  private Node root;

  // Left Rotation
  void leftRotate(Node x) {
    Node y = x.right; // Set y
    x.right = y.left; // Turn y's left subtree into x's right subtree
    if (y.left != null) {
      y.left.parent = x;
    }
    y.parent = x.parent; // Link x's parent to y
    if (x.parent == null) {
      root = y; // y becomes root
    } else if (x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }
    y.left = x; // Put x on y's left
    x.parent = y;
  }

  // Right Rotation
  void rightRotate(Node y) {
    Node x = y.left; // Set x
    y.left = x.right; // Turn x's right subtree into y's left subtree
    if (x.right != null) {
      x.right.parent = y;
    }
    x.parent = y.parent; // Link y's parent to x
    if (y.parent == null) {
      root = x; // x becomes root
    } else if (y == y.parent.left) {
      y.parent.left = x;
    } else {
      y.parent.right = x;
    }
    x.right = y; // Put y on x's right
    y.parent = x;
  }

  // Example 1: Performing Left Rotation
  public void example1() {
    Node node10 = new Node(10); // Root
    Node node20 = new Node(20); // Right child of 10
    Node node30 = new Node(30); // Right child of 20

    node10.right = node20;
    node20.parent = node10;
    node20.right = node30;
    node30.parent = node20;

    // Tree before rotation:
    // 10B
    // \
    // 20R
    // \
    // 30R

    leftRotate(node10);

    // Tree after rotation:
    // 20R
    // / \
    // 10B 30R
  }

  // Example 2: Performing Right Rotation
  public void example2() {
    Node node30 = new Node(30); // Root
    Node node20 = new Node(20); // Left child of 30
    Node node10 = new Node(10); // Left child of 20

    node30.left = node20;
    node20.parent = node30;
    node20.left = node10;
    node10.parent = node20;

    // Tree before rotation:
    // 30B
    // /
    // 20R
    // /
    // 10R

    rightRotate(node30);

    // Tree after rotation:
    // 20R
    // / \
    // 10R 30B
  }

  // Example 3: Performing Left-Right Rotation
  public void example3() {
    Node node30 = new Node(30); // Root
    Node node10 = new Node(10); // Left child of 30
    Node node20 = new Node(20); // Right child of 10

    node30.left = node10;
    node10.parent = node30;
    node10.right = node20;
    node20.parent = node10;

    // Tree before rotations:
    // 30B
    // /
    // 10R
    // \
    // 20R

    leftRotate(node10);
    rightRotate(node30);

    // Tree after rotations:
    // 20R
    // / \
    // 10R 30B
  }

  // Example 4: Performing Right-Left Rotation
  public void example4() {
    Node node10 = new Node(10); // Root
    Node node30 = new Node(30); // Right child of 10
    Node node20 = new Node(20); // Left child of 30

    node10.right = node30;
    node30.parent = node10;
    node30.left = node20;
    node20.parent = node30;

    // Tree before rotations:
    // 10B
    // \
    // 30R
    // /
    // 20R

    rightRotate(node30);
    leftRotate(node10);

    // Tree after rotations:
    // 20R
    // / \
    // 10B 30R
  }
}

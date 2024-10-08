class AVLTree {

  class Node {
      int key, height;
      Node left, right;

      Node(int d) {
          key = d;
          height = 1;
      }
  }

  private Node root;

  // Utility function to get the height of the tree
  private int height(Node N) {
      if (N == null)
          return 0;
      return N.height;
  }

  // Utility function to get maximum of two integers
  private int max(int a, int b) {
      return (a > b) ? a : b;
  }

  // Right rotate subtree rooted with y
  private Node rightRotate(Node y) {
      Node x = y.left;
      Node T2 = x.right;

      // Perform rotation
      x.right = y;
      y.left = T2;

      // Update heights
      y.height = max(height(y.left), height(y.right)) + 1;
      x.height = max(height(x.left), height(x.right)) + 1;

      // Return new root
      return x;
  }

  // Left rotate subtree rooted with x
  private Node leftRotate(Node x) {
      Node y = x.right;
      Node T2 = y.left;

      // Perform rotation
      y.left = x;
      x.right = T2;

      // Update heights
      x.height = max(height(x.left), height(x.right)) + 1;
      y.height = max(height(y.left), height(y.right)) + 1;

      // Return new root
      return y;
  }

  // Get Balance factor of node N
  private int getBalance(Node N) {
      if (N == null)
          return 0;
      return height(N.left) - height(N.right);
  }

  public void insert(int key) {
      root = insertNode(root, key);
  }

  private Node insertNode(Node node, int key) {
      // 1. Perform the normal BST insertion
      if (node == null)
          return (new Node(key));

      if (key < node.key)
          node.left = insertNode(node.left, key);
      else if (key > node.key)
          node.right = insertNode(node.right, key);
      else // Duplicate keys are not allowed
          return node;

      // 2. Update height of this ancestor node
      node.height = 1 + max(height(node.left), height(node.right));

      // 3. Get the balance factor of this ancestor node to check whether
      // this node became unbalanced
      int balance = getBalance(node);

      // If this node becomes unbalanced, then there are 4 cases

      // Left Left Case
      if (balance > 1 && key < node.left.key)
          return rightRotate(node);

      // Right Right Case
      if (balance < -1 && key > node.right.key)
          return leftRotate(node);

      // Left Right Case
      if (balance > 1 && key > node.left.key) {
          node.left = leftRotate(node.left);
          return rightRotate(node);
      }

      // Right Left Case
      if (balance < -1 && key < node.right.key) {
          node.right = rightRotate(node.right);
          return leftRotate(node);
      }

      // return the (unchanged) node pointer
      return node;
  }

  public void delete(int key) {
      root = deleteNode(root, key);
  }

  private Node deleteNode(Node root, int key) {
      // STEP 1: PERFORM STANDARD BST DELETE

      if (root == null)
          return root;

      // If the key to be deleted is smaller than the root's key,
      // then it lies in left subtree
      if (key < root.key)
          root.left = deleteNode(root.left, key);

      // If the key to be deleted is greater than the root's key,
      // then it lies in right subtree
      else if (key > root.key)
          root.right = deleteNode(root.right, key);

      // if key is same as root's key, then this is the node
      // to be deleted
      else {
          // node with only one child or no child
          if ((root.left == null) || (root.right == null)) {
              Node temp = null;
              if (temp == root.left)
                  temp = root.right;
              else
                  temp = root.left;

              // No child case
              if (temp == null) {
                  temp = root;
                  root = null;
              } else // One child case
                  root = temp; // Copy the contents of the non-empty child
          } else {
              // node with two children: Get the inorder successor (smallest
              // in the right subtree)
              Node temp = minValueNode(root.right);

              // Copy the inorder successor's data to this node
              root.key = temp.key;

              // Delete the inorder successor
              root.right = deleteNode(root.right, temp.key);
          }
      }

      // If the tree had only one node then return
      if (root == null)
          return root;

      // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
      root.height = max(height(root.left), height(root.right)) + 1;

      // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
      // this node became unbalanced)
      int balance = getBalance(root);

      // If this node becomes unbalanced, then there are 4 cases

      // Left Left Case
      if (balance > 1 && getBalance(root.left) >= 0)
          return rightRotate(root);

      // Left Right Case
      if (balance > 1 && getBalance(root.left) < 0) {
          root.left = leftRotate(root.left);
          return rightRotate(root);
      }

      // Right Right Case
      if (balance < -1 && getBalance(root.right) <= 0)
          return leftRotate(root);

      // Right Left Case
      if (balance < -1 && getBalance(root.right) > 0) {
          root.right = rightRotate(root.right);
          return leftRotate(root);
      }

      return root;
  }

  // A utility function to get the node with minimum key value
  private Node minValueNode(Node node) {
      Node current = node;

      // loop down to find the leftmost leaf
      while (current.left != null)
          current = current.left;

      return current;
  }

  // A utility function to print preorder traversal of the tree.
  // The function also prints height of every node
  public void preOrder(Node node) {
      if (node != null) {
          System.out.print(node.key + " ");
          preOrder(node.left);
          preOrder(node.right);
      }
  }

  public static void main(String[] args) {
      AVLTree tree = new AVLTree();

      // Insert elements
      tree.insert(10);
      tree.insert(20);
      tree.insert(30);
      tree.insert(40);
      tree.insert(50);
      tree.insert(25);

      // The constructed AVL Tree would be
      //       30
      //      /  \
      //    20   40
      //   /  \    \
      //  10  25   50
      System.out.println("Preorder traversal of constructed tree is : ");
      tree.preOrder(tree.root);

      // Delete elements
      tree.delete(40);

      // The AVL Tree after deletion of 40
      //       30
      //      /  \
      //    20   50
      //   /  \     
      //  10  25    
      System.out.println("\nPreorder traversal after deletion of 40 :");
      tree.preOrder(tree.root);
  }
}

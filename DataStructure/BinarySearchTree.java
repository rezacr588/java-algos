public class BinarySearchTree {

  private Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(int key) {
    root = insertRec(root, key);
  }

  private Node insertRec(Node root, int key) {
    if (root == null) {
      root = new Node(key);
      return root;
    }
    if (key < root.key) {
      root.left = insertRec(root.left, key);
    } else if (key > root.key) {
      root.right = insertRec(root.right, key);
    }
    return root;
  }

  public boolean search(int key) {
    return searchRec(root, key);
  }

  private boolean searchRec(Node root, int key) {
    if (root == null) {
      return false;
    }
    if (key == root.key) {
      return true;
    }
    return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
  }

  public void inorder() {
    inorderRec(root);
  }

  private void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " ");
      inorderRec(root.right);
    }
  }

  public void preorder() {
    preorderRec(root);
  }

  private void preorderRec(Node root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preorderRec(root.left);
      preorderRec(root.right);
    }
  }

  public void postorder() {
    postorderRec(root);
  }

  private void postorderRec(Node root) {
    if (root != null) {
      postorderRec(root.left);
      postorderRec(root.right);
      System.out.print(root.key + " ");
    }
  }

  private static class Node {
    int key;
    Node left, right;

    public Node(int item) {
      key = item;
      left = right = null;
    }
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);

    System.out.println("Inorder traversal:");
    bst.inorder();

    System.out.println("\nPreorder traversal:");
    bst.preorder();

    System.out.println("\nPostorder traversal:");
    bst.postorder();

    int searchKey = 30;
    System.out.println("\nSearch " + searchKey + ": " + bst.search(searchKey));
  }
}

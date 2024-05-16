class BSTNode {
    int info;
    BSTNode left, right;

    // Constructor
    public BSTNode(int info) {
        this.info = info;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    BSTNode root;

    // Constructor
    public BinarySearchTree() {
        this.root = null;
    }

    // Method to insert a node into the BST
    public void insert(int info) {
        root = insertRec(root, info);
    }

    // A recursive function to insert a new key in BST
    private BSTNode insertRec(BSTNode root, int info) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new BSTNode(info);
            return root;
        }

        // Otherwise, recur down the tree
        if (info < root.info)
            root.left = insertRec(root.left, info);
        else if (info > root.info)
            root.right = insertRec(root.right, info);

        // return the (unchanged) node pointer
        return root;
    }

    // A utility function to do inorder traversal of BST
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // A recursive function to do inorder traversal of BST
    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.info + " ");
            inorderRec(root.right);
        }
    }

    // A utility function to do preorder traversal of BST
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    // A recursive function to do preorder traversal of BST
    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.info + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // A utility function to do postorder traversal of BST
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // A recursive function to do postorder traversal of BST
    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.info + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal:");
        tree.inorder();

        // Print preorder traversal of the BST
        System.out.println("Preorder traversal:");
        tree.preorder();

        // Print postorder traversal of the BST
        System.out.println("Postorder traversal:");
        tree.postorder();
    }
}

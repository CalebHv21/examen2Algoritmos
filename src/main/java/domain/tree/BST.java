package domain.tree;

/* *
 *
 * @author Profesor Lic. Gilberth Chaves A.
 * BST = Binary Search Tree (Arbol de Búsqueda Binaria)
 * */
public class BST {
    private BTreeNode root;

    public BST() {
        this.root = null;
    }

    public BTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public int size() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        return size(root);
    }

    private int size(BTreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public boolean contains(Object element) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        return binarySearch(root, element);
    }

    private boolean binarySearch(BTreeNode node, Object element) {
        if (node == null) return false;
        if (util.Utility.compare(node.data, element) == 0) return true;
        if (util.Utility.compare(element, node.data) < 0) {
            return binarySearch(node.left, element);
        }
        return binarySearch(node.right, element);
    }

    public void add(Object element) {
        this.root = add(root, element);
    }

    private BTreeNode add(BTreeNode node, Object element) {
        if (node == null) {
            node = new BTreeNode(element);
        } else if (util.Utility.compare(element, node.data) < 0) {
            node.left = add(node.left, element);
        } else if (util.Utility.compare(element, node.data) > 0) {
            node.right = add(node.right, element);
        }
        return node;
    }

    public void remove(Object element) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        root = remove(root, element);
    }

    private BTreeNode remove(BTreeNode node, Object element) throws TreeException {
        if (node != null) {
            if (util.Utility.compare(element, node.data) < 0) {
                node.left = remove(node.left, element);
            } else if (util.Utility.compare(element, node.data) > 0) {
                node.right = remove(node.right, element);
            } else if (util.Utility.compare(node.data, element) == 0) {
                if (node.left == null && node.right == null) return null;
                if (node.left != null && node.right == null) return node.left;
                if (node.left == null && node.right != null) return node.right;

                Object value = min(node.right);
                node.data = value;
                node.right = remove(node.right, value);
            }
        }
        return node;
    }

    public int height() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        return height(root);
    }

    private int height(BTreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public Object min() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        return min(root);
    }

    private Object min(BTreeNode node) {
        if (node.left != null) {
            return min(node.left);
        }
        return node.data;
    }

    public Object max() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        return max(root);
    }

    private Object max(BTreeNode node) {
        if (node.right != null) {
            return max(node.right);
        }
        return node.data;
    }

    public void removeSubTree1() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Search Tree is empty");
        }
        if (root != null && ((root.left != null && root.right == null) || (root.left == null && root.right != null))) {
            this.root = null;
            return;
        }
        removeSubTree1(this.root);
    }

    private void removeSubTree1(BTreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            boolean childHasOneChild = (node.left.left != null && node.left.right == null) || (node.left.left == null && node.left.right != null);
            if (childHasOneChild) {
                node.left = null;
            } else {
                removeSubTree1(node.left);
            }
        }

        if (node.right != null) {
            boolean childHasOneChild = (node.right.left != null && node.right.right == null) || (node.right.left == null && node.right.right != null);
            if (childHasOneChild) {
                node.right = null;
            } else {
                removeSubTree1(node.right);
            }
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Binary Search Tree is empty";
        }
        return "Binary Search Tree Content:"
                + "\nPreOrder: " + preOrder(root)
                + "\nInOrder:  " + inOrder(root)
                + "\nPostOrder:" + postOrder(root);
    }

    public String preOrder() throws TreeException {
        if (isEmpty()) throw new TreeException("Binary Search Tree is empty");
        return preOrder(root);
    }

    private String preOrder(BTreeNode node) {
        if (node == null) return "";
        return node.data + " " + preOrder(node.left) + preOrder(node.right);
    }

    public String inOrder() throws TreeException {
        if (isEmpty()) throw new TreeException("Binary Search Tree is empty");
        return inOrder(root);
    }

    private String inOrder(BTreeNode node) {
        if (node == null) return "";
        return inOrder(node.left) + node.data + " " + inOrder(node.right);
    }

    public String postOrder() throws TreeException {
        if (isEmpty()) throw new TreeException("Binary Search Tree is empty");
        return postOrder(root);
    }

    private String postOrder(BTreeNode node) {
        if (node == null) return "";
        return postOrder(node.left) + postOrder(node.right) + node.data + " ";
    }
}
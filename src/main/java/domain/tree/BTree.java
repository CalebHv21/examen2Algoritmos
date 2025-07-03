package domain.tree;

public class BTree {
    private BTreeNode root;

    public BTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public int size() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        return size(root);
    }

    private int size(BTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public boolean contains(Object element) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        return contains(root, element);
    }

    private boolean contains(BTreeNode node, Object element) {
        if (node == null) {
            return false;
        }
        if (util.Utility.compare(node.data, element) == 0) {
            return true;
        }
        return contains(node.left, element) || contains(node.right, element);
    }

    public void add(Object element) {
        this.root = add(root, element);
    }

    private BTreeNode add(BTreeNode node, Object element) {
        if (node == null) {
            node = new BTreeNode(element);
        } else {
            int value = util.Utility.random(100);
            if (value % 2 == 0) {
                node.left = add(node.left, element);
            } else {
                node.right = add(node.right, element);
            }
        }
        return node;
    }

    public int height() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        return height(root);
    }

    private int height(BTreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public String oddPathSumList() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        String result = "Odd Path Sum List:\n" + oddPathSumList(root, 0);
        return result.trim();
    }

    private String oddPathSumList(BTreeNode node, int sum) {
        if (node == null) {
            return "";
        }

        int currentPathSum = sum + (Integer) node.data;
        String result = "";

        if (currentPathSum % 2 != 0) {
            result = node.data + " ";
        }

        result += oddPathSumList(node.left, currentPathSum);
        result += oddPathSumList(node.right, currentPathSum);

        return result;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Binary Tree is empty";
        }
        return "Binary Tree Content:"
                + "\nPreOrder: " + preOrder(root).trim()
                + "\nInOrder:  " + inOrder(root).trim()
                + "\nPostOrder:" + postOrder(root).trim();
    }

    public String preOrder() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        return preOrder(root);
    }

    private String preOrder(BTreeNode node) {
        if (node == null) return "";
        return node.data + " " + preOrder(node.left) + preOrder(node.right);
    }

    public String inOrder() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        return inOrder(root);
    }

    private String inOrder(BTreeNode node) {
        if (node == null) return "";
        return inOrder(node.left) + node.data + " " + inOrder(node.right);
    }

    public String postOrder() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("Binary Tree is empty");
        }
        return postOrder(root);
    }

    private String postOrder(BTreeNode node) {
        if (node == null) return "";
        return postOrder(node.left) + postOrder(node.right) + node.data + " ";
    }
}
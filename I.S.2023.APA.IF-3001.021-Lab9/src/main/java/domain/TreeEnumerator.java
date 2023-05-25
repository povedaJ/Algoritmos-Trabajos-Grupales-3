package domain;

public class TreeEnumerator {
    private int counter;

    public TreeEnumerator() {
        this.counter = 1;
    }

    public String enumeratePreOrder(BTreeNode root) {
        counter = 1;
        StringBuilder result = new StringBuilder();
        enumeratePreOrderRecursive(root, result);
        return result.toString();
    }

    private void enumeratePreOrderRecursive(BTreeNode node, StringBuilder result) {
        if (node != null) {
            result.append(counter).append(": ").append(node.data).append("(").append(node.path).append("), ");
            counter++;
            enumeratePreOrderRecursive(node.left, result);
            enumeratePreOrderRecursive(node.right, result);
        }
    }

    public String enumerateInOrder(BTreeNode root) {
        counter = 1;
        StringBuilder result = new StringBuilder();
        enumerateInOrderRecursive(root, result);
        return result.toString();
    }

    private void enumerateInOrderRecursive(BTreeNode node, StringBuilder result) {
        if (node != null) {
            enumerateInOrderRecursive(node.left, result);
            result.append(counter).append(": ").append(node.data).append("(").append(node.path).append("), ");
            counter++;
            enumerateInOrderRecursive(node.right, result);
        }
    }

    public String enumeratePostOrder(BTreeNode root) {
        counter = 1;
        StringBuilder result = new StringBuilder();
        enumeratePostOrderRecursive(root, result);
        return result.toString();
    }

    private void enumeratePostOrderRecursive(BTreeNode node, StringBuilder result) {
        if (node != null) {
            enumeratePostOrderRecursive(node.left, result);
            enumeratePostOrderRecursive(node.right, result);
            result.append(counter).append(": ").append(node.data).append("(").append(node.path).append("), ");
            counter++;
        }
    }
}
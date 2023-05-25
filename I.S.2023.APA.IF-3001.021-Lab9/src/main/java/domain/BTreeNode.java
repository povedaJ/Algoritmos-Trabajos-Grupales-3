package domain;

public class BTreeNode {
    public Object data;
    public String path; //etiqueta con la ruta del nodo binario, ex. root/left, root/right
    public BTreeNode left, right;

    public BTreeNode(Object data) {
        this.data = data;
        this.left = this.right = null;
    }

    public BTreeNode(Object data, String path) {
        this.data = data;
        this.path = path;
        this.left = this.right = null;
    }
}

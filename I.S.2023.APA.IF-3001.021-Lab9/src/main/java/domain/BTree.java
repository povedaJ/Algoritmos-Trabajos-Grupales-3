package domain;

public class BTree implements Tree {
    private BTreeNode root;

    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    public BTree() {
        this.root = null;
    }

    @Override
    public int size() throws TreeException {
        if(isEmpty()){
            throw new TreeException("Binary Tree is empty");
        }
        return size(root);
    }

    private int size(BTreeNode node){
        if(node==null)
            return 0;
        else
            return 1+size(node.left)+size(node.right);
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object element) throws TreeException {
        if(isEmpty()){
            throw new TreeException("Binary Tree is empty");
        }
        return binarySearch(root, element);
    }

    private boolean binarySearch(BTreeNode node, Object element){
        if(node==null)
            return false;
        else if(util.Utility.compare(node.data, element)==0)
            return true; //ya lo encontro
        else
            return binarySearch(node.left, element) || binarySearch(node.right, element);

    }

    @Override
    public void add(Object element) {
        //root = add(root, element);
        root = add(root, element, "root");
    }

    private BTreeNode add(BTreeNode node, Object element){
        if(node==null){ //el arbol esta vacio
            node = new BTreeNode(element);
        }else{
            int value = util.Utility.random(10);
            if(value%2==0){ //si son pares va como hijo izq
                node.left = add(node.left, element);
            }else{ //va como hijo der
                node.right = add(node.right, element);
            }
        }
        return node;
    }

    private BTreeNode add(BTreeNode node, Object element, String path){
        if(node==null){ //el arbol esta vacio
            node = new BTreeNode(element, path);
        }else{
            int value = util.Utility.random(10);
            if(value%2==0){ //si son pares va como hijo izq
                node.left = add(node.left, element, path+"/left");
            }else{ //va como hijo der
                node.right = add(node.right, element, path+"/right");
            }
        }
        return node;
    }

    @Override
    public void remove(Object element) throws TreeException {
        if(isEmpty()){
            throw new TreeException("Binary Tree is empty");
        }
        root = remove(root, element);

    }

    private BTreeNode remove(BTreeNode node, Object element){
        if(node!=null){
            if(util.Utility.compare(node.data, element)==0){ //ya encontramos el elemento a eliminar
                //Caso 1. Es un nodo sin hijos. Es una hoja
                if(node.left==null && node.right==null)
                    return null;
                //Caso 2. El nodo solo tiene un hijo
                else if(node.left!=null && node.right==null){
                    node.left = newPathLabel(node.left, node.path);
                    return node.left; //retorna el subarbol izq y sustituye el nodo actual
                } else if(node.left==null && node.right!=null){
                    node.right = newPathLabel(node.right, node.path);
                    return node.right; //retorna el subarbol derecho y sustituye el nodo actual
                //Caso 3. El nodo tiene 2 hijos
                }else if(node.left!=null && node.right!=null){
                    Object value = getLeaf(node.right);
                    node.data = value;
                    node.right = removeLeaf(node.right, value);
                }

            }
            //si no hemos encontrado el elemento, debemos buscar por la izq y por la der
            node.left = remove(node.left, element);
            node.right = remove(node.right, element);
        }
        return node; //retorna el nodo modificado
    }

    private BTreeNode newPathLabel(BTreeNode node, String path) {
        if(node!=null){
            node.path = path;
            node.left = newPathLabel(node.left, path+"/left");
            node.right = newPathLabel(node.right, path+"/right");
        }
        return node;
    }

    private BTreeNode removeLeaf(BTreeNode node, Object element) {
        if(node==null)
            return null;
            //Si es una hoja
        else if(node.left==null && node.right==null && util.Utility.compare(node.data, element)==0)
            return null; //es la hoja que andamos buscando y se debe eliminar
        else{
            node.left = removeLeaf(node.left, element);
            node.right = removeLeaf(node.right, element);
        }
        return node;
    }

    private Object getLeaf(BTreeNode node) {
        if(node==null)
            return null;
        //Si es una hoja
        else if(node.left==null && node.right==null)
            return node.data; //es una hoja
        else{
            if((getLeaf(node.left)==null))
                return getLeaf(node.right);
        }
        return null;
    }

    @Override
    public int height(Object element) throws TreeException {
        if(isEmpty()){
            throw new TreeException("Binary Tree is empty");
        }
        return height(root, element, 0);
    }

    private int height(BTreeNode node, Object element, int counter){
        if(node==null)
            return 0;
        else if(util.Utility.compare(node.data, element)==0)
            return counter;
        else //en este caso debe buscar por la izq y por la der
            return Math.max(height(node.left, element, ++counter), height(node.right, element, counter));
    }

    @Override
    public int height() throws TreeException {
        if(isEmpty()){
            throw new TreeException("Binary Tree is empty");
        }
        return height(root)-1; //pq no cuente el nivel de la raiz
    }

    private int height(BTreeNode node){
        if(node==null)
            return 0;
        else
            return 1+Math.max(height(node.left), height(node.right));
    }

    @Override
    public Object min() throws TreeException {
        return null;
    }

    //private Object min(BTreeNode node)

    @Override
    public Object max() throws TreeException {
        return null;
    }

    //private Object max(BTreeNode node)

    @Override
    public String preOrder() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Tree is empty");
        return "PreOrder Transversal Tour: "+preOrder(root)+"\n";
    }

    //metodo interno
    //preOrder: node-left-right
    private String preOrder(BTreeNode node){
        String result="";
        if(node!=null){
            //result=node.data+", ";
            result=node.data+"("+node.path+"), ";
            result+=preOrder(node.left);
            result+=preOrder(node.right);
        }
        return result;
    }


    @Override
    public String InOrder() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Tree is empty");
        return "InOrder Transversal Tour: "+inOrder(root)+"\n";
    }

    //metodo interno
    //preOrder: left-node-right
    private String inOrder(BTreeNode node){
        String result="";
        if(node!=null){
            result=inOrder(node.left);
            result+=node.data+", ";
            result+=inOrder(node.right);
        }
        return result;
    }

    @Override
    public String postOrder() throws TreeException {
        if(isEmpty())
            throw new TreeException("Binary Tree is empty");
        return "PostOrder Transversal Tour: "+postOrder(root)+"\n";
    }

    //metodo interno
    //preOrder: left-right-node
    private String postOrder(BTreeNode node){
        String result="";
        if(node!=null){
            result=postOrder(node.left);
            result+=postOrder(node.right);
            result+=node.data+", ";
        }
        return result;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Binary tree is empty";
        String result = "Binary Tree Tour...\n";
        result+="PreOrder: "+preOrder(root)+"\n";
        result+="InOrder: "+inOrder(root)+"\n";
        result+="PostOrder: "+postOrder(root)+"\n";
        return result;
    }
}

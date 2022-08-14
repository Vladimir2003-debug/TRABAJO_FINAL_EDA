package datastructures.binarytree;
public abstract class BinaryTree<E> {
    protected Node<E> root;

    /**
     * Constructor
     */
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(E root) {
        this.root = new Node<E>(root);
    }

    /**
     * Imprime el arbol en la forma raiz-izquierda-derecha
     * @return El arbol impreso
     */
    public String preOrder() {
        return preOrder(root);
    }

    private String preOrder(Node<E> node) {
        if (node == null) {
            return "";
        }
        return node.toString() + " " + preOrder(node.getLeft()) + " " + preOrder(node.getRight());
    }

    /**
     * Imprime el Arbol en la forma izquierda-raiz-derecha
     * @return El arbol impreso
     */
    public String inOrder() {
        return inOrder(root);
    }

    private String inOrder(Node<E> node) {
        if (node == null) {
            return "";
        }
        return inOrder(node.getLeft()) + " " + node.toString() + " " + inOrder(node.getRight());
    }

    /**
     * Imprime el arbol en la forma izquierda-derecha-raiz
     * @return El arbol PostOrder
     */
    public String postOrder() {
        return postOrder(root);
    }

    private String postOrder(Node<E> node) {
        if (node == null) {
            return "";
        }
        return postOrder(node.getLeft()) + " " + postOrder(node.getRight()) + " " + node.toString();
    }

    /**
     * Rotacion Simple Izquierda de un nodo
     */
    public void rotateLeft() {
        if (root == null) {
            return;
        }
        Node<E> newRoot = root.getRight();
        root.setRight(newRoot.getLeft());
        newRoot.setLeft(root);
        root = newRoot;
    }

    /**
     * Rotacion Simple Derecha de un nodo
     */
    public void rotateRight() {
        if (root == null) {
            return;
        }
        Node<E> newRoot = root.getLeft();
        root.setLeft(newRoot.getRight());
        newRoot.setRight(root);
        root = newRoot;
    }

    /**
     * Evalua si el arbol esa vacio
     * @return True si el arbol esta vacio
     */ 
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Elimina el menor del arbol
     */
    public E minRemove() {
        E min = minRecover();
        this.root = minRemove(this.root);
        return min;
    }

    /**
     * Recupera el menor del arbol
     * @return El menor del arbol
     */
    public E minRecover() {
        if (root == null) {
            return null;
        }
        return minRecover(root);
    }

    public E minRecover(Node<E> node) {
        if (node.getLeft() == null) {
            return node.getData();
        }
        return minRecover(node.getLeft());
    }    

    /**
     * Elimina el menor de la izquierda de un nodo
     * @param node Nodo a eliminar
     * @return Nodo eliminado
     */
    protected Node<E> minRemove(Node<E> actual) {
        if(actual.getLeft() != null)
            actual.setLeft(minRemove(actual.getLeft()));
        else {
            actual = actual.getRight();
        }
        return actual;   
    }
    
    public abstract void insert(E x);

    public abstract void remove(E x) throws ItemNotFound;

    public abstract E search(E x) throws ItemNotFound;

}

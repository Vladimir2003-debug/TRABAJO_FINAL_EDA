package datastructures.binarytree;
public class BST<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Constructor
     */
    public BST() {
        super();
    }

    public BST(E root) {
        super(root);
    }

    /**
     * Busqueda en un arbol
     * @param item El item a buscar
     * @return El dato que contiene el elemento buscado
     * @throws ItemNotFound Si el elemento no se encuentra en el arbol
     */
    public E search(E x) throws ItemNotFound {
        Node<E> res = searchNode(x, root);
        if (res == null)
            throw new ItemNotFound("El dato " + x + "no esta");
        return res.getData();
    }

    protected Node<E> searchNode(E x, Node<E> n) {
        if (n == null)
            return null;
        else {
            int resC = n.getData().compareTo(x);
            if (resC < 0)
                return searchNode(x, n.getRight());
            else if (resC > 0)
                return searchNode(x, n.getLeft());
            else
                return n;
        }
    }

    /**
     * Inserccion de un elemento en el arbol
     * @param item El elemento a insertar
     */
    public void insert(E data) {
        root = insert(root, data);
    }

    public int height(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<E>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), data));
        }
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;
    }

    /**
     * Eliminacion de un elemento del arbol
     * @param x El elemento a eliminar
     * @throws ItemNotFound Si el elemento no esta en el arbol
     */

    public void remove(E x) throws ItemNotFound {
        this.root = removeNode(x, this.root);
    }

    protected Node<E> removeNode(E x, Node<E> actual) throws ItemNotFound {
        Node<E> res = actual;
        if (actual == null)
            throw new ItemNotFound(x + "no esta");

        int resC = actual.getData().compareTo(x);
        if (resC < 0)
            res.setRight(removeNode(x, actual.getRight()));
        else if (resC > 0)
            res.setLeft(removeNode(x, actual.getLeft()));
        else if (actual.getLeft() != null && actual.getRight() != null) {// dos hijos
            // res.data = minRecover(actual.getRight()).data;
            res.setData(minRecover(actual.getRight()));
            res.setRight(minRemove(actual.getRight()));
        } else { // 1 hijo o ninguno
            res = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
        }
        return res;
    }

    // Precondition: !isEmpty()
    public E minRemove() {
        E min = minRecover(); // devuelve el menor del árbol
        this.root = minRemove(this.root);
        return min;
    }

    // Elimina el menor de la izquierda de un nodo
    protected Node<E> minRemove(Node<E> actual) {
        if (actual.getLeft() != null) { // busca el mínimo
            actual.setLeft(minRemove(actual.getLeft()));
        } else { // elimina el mínimo
            actual = actual.getRight();
        }
        return actual;
    }
}

package datastructures.binarytree;

public class Node<E> {
    private E data;
    private int height;
    private Node<E> left, right;

    public Node(E data) {
        this.data = data;
        left = right = null;
    }

    public Node(E data, Node<E> left, Node<E> right, int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public E getElement() {
        return data;
    }
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public String toString() {
        return data.toString();
    }

}

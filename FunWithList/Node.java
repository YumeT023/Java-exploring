package FunWithList;

public class Node<T> {
    // basic LinkedList structure
    public T data;
    public Node<T> next;

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    Node(T data) {
        this(data, null);
    }
}

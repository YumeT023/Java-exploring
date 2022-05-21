package FunWithList;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunWithList {
    static <T, R> Node<R> map(Node<T> node, Function<T, R> f) {
        return node == null ? null : new Node<>(f.apply(node.data), map(node.next, f));
    }

    static <T> Node<T> filter(Node<T> node, Predicate<T> p) {
        return node == null ? null : p.test(node.data) ? new Node<>(node.data, filter(node.next, p)) : filter(node.next, p);
    }

    static <T> T reduce(Node<T> node, BiFunction<T, T, T> f, T init) {
        return node == null ? init : reduce(node.next, f, f.apply(init, node.data));
    }

    public static void main(String[] args) {
    }
}

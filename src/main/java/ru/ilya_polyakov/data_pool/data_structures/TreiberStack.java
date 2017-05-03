package ru.ilya_polyakov.data_pool.data_structures;


import ru.ilya_polyakov.data_pool.data_structures.exceptions.StackIsEmptyException;

import java.util.concurrent.atomic.AtomicReference;

public class TreiberStack<E> implements Stack<E> {

    private AtomicReference<Node<E>> top = new AtomicReference<Node<E>>(null);

    @Override
    public void push(E value) {
        Node<E> newTop = new Node<>(value);
        while (!tryPush(newTop));
    }

    @Override
    public E pop() {
        Node<E> returnNode;
        while ((returnNode = tryPop()) == null);
        return returnNode.value;
    }

    protected boolean tryPush(Node<E> node) {
        Node<E> oldTop = top.get();
        node.next = oldTop;
        return top.compareAndSet(oldTop, node);
    }

    protected Node<E> tryPop() {
        Node<E> oldTop = top.get();
        if (oldTop == null) {
            throw new StackIsEmptyException();
        }

        Node<E> newTop = oldTop.next;
        if (top.compareAndSet(oldTop, newTop)) {
            return oldTop;
        } else {
            return null;
        }
    }

    private static class Node<E> {
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
        }

    }
}

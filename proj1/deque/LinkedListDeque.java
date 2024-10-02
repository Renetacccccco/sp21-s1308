package deque;

public class LinkedListDeque<T> {
    public class Node {
        Node prev;
        T item;
        Node next;

        Node(T item1, Node prev1, Node next1) {
            item = item1;
            prev = prev1;
            next = next1;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        size += 1;
        Node p = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    public void addLast(T item) {
        size += 1;
        Node p = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node current = sentinel.next;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            size -= 1;
            Node first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            return first.item;
        }
    }

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            size -= 1;
            Node last = sentinel.prev;
            sentinel.prev = last.prev;
            last.prev.next = sentinel;
            return last.item;
        }
    }

    public T get(int index) {
       if (index < size && index >= 0) {
           Node current = sentinel;
           while (index >= 0) {
               current = current.next;
               index--;
           }
           return current.item;
       } else {
           return null;
       }
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(this.sentinel.next, index);
    }

    private T getRecursiveHelper(Node current, int index) {
        if (index == 0) {
            return current.item;
        }
        return getRecursiveHelper(current.next, index - 1);
    }



}

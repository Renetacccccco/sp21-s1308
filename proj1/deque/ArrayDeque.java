package deque;

public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            T[] copyArray = (T[]) new Object[size * 2];
            int actualFirst = Math.floorMod((nextFirst + 1), size);
            for (int i = 0; i < size; i++) {
                copyArray[i] = items[Math.floorMod(actualFirst + i, size)];
            }
            items = copyArray;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size += 1;
    }

    public void addLast(T x) {
        if (size == items.length) {
            T[] copyArray = (T[]) new Object[size * 2];
            int actualFirst = Math.floorMod((nextFirst+1), size);
            for (int i = 0; i < size; i++) {
                copyArray[i] = items[Math.floorMod(actualFirst + i, size)];
            }
            items = copyArray;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int current = Math.floorMod(nextFirst, items.length);
        for (int i = 0; i < size; i++) {
            current = Math.floorMod(current + 1, items.length);
            System.out.print(items[current] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            nextFirst = Math.floorMod(nextFirst + 1, items.length);
            return items[nextFirst];
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            nextLast = Math.floorMod(nextLast - 1, items.length);
            return items[nextLast];
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            int actualIndex = Math.floorMod(nextFirst + 1 + index, items.length);
            return items[actualIndex];
        }
        return null;
    }


}

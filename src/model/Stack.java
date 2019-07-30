package model;

public interface Stack<T> {

    // O(1)
    void push(T newItem);

    // O(1)
    T pop();

    // O(n)
    boolean contains(T item);

    // O(n)
    T access(T item);

    int size();

}

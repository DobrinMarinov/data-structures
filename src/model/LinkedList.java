package model;

public interface LinkedList<T> {

    //O(1)
    void add(T item);

    //O(n)
    void insert(T item, int position);

    //O(1)
    T remove();

    //O(n)
    T get(int position);

    //O(n)
    int find(T item);

    //O(n)
    T removeAt(int position);

}

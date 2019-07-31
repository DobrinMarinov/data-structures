package model;

public interface Queue<T> {

    int size();

    //O(1)
    void enQueue(T item);

    //O(1)
    T deQueue();

    //O(n)
    boolean contains(T item);

    //0(1)
    T access(int position);

}

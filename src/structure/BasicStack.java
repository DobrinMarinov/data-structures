package structure;

import model.Stack;

public class BasicStack<T> implements Stack {

    private static final int DATA_CAPACITY = 1000;
    private static final int INCREASE_CAPACITY_RATE = 1;

    private T[] data;
    private int stackPointer;

    public BasicStack() {
        data = (T[]) new Object[DATA_CAPACITY];
        stackPointer = 0;
    }

    @Override
    public void push(Object newItem) {
        if(stackPointer == DATA_CAPACITY) {
            data = (T[]) new Object[DATA_CAPACITY + INCREASE_CAPACITY_RATE];
        }
        data[stackPointer++] = (T) newItem;
    }

    public T pop() {
        if(stackPointer == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[--stackPointer];
    }

    @Override
    public boolean contains(Object item) {
        for (int i = 0; i < stackPointer; i++) {
            if(data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T access(Object item) {
        while (stackPointer > 0) {
            T tempItem = pop();
            if(item.equals(tempItem)) {
                return tempItem;
            }
        }
        throw new IllegalArgumentException("No such element in the stack: " + item);
    }

    public int size() {
        return stackPointer;
    }

}

package structure;

import model.Stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements Stack {

    private List<T> data;
    private int stackPointer;

    public ListStack() {
        data = new ArrayList<>();
    }

    @Override
    public void push(Object newItem) {
        data.add((T) newItem);
        stackPointer++;
    }

    @Override
    public T pop() {
        if(stackPointer == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(--stackPointer);
    }

    @Override
    public boolean contains(Object item) {
        return data.contains(item) ? true : false;
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

    @Override
    public int size() {
        return stackPointer;
    }
}

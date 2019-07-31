package structure.stack;

import model.Stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> implements Stack {

    private List<T> data;

    public ListStack() {
        data = new ArrayList<>();
    }

    @Override
    public void push(Object newItem) {
        data.add((T) newItem);
    }

    @Override
    public T pop() {
        int pointer = data.size();
        if(pointer == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T result = data.get(pointer - 1);
        data.remove(pointer - 1);
        return result;
    }

    @Override
    public boolean contains(Object item) {
        return data.contains(item) ? true : false;
    }

    @Override
    public T access(Object item) {
        while (data.size() > 0) {
            T tempItem = pop();
            if(item.equals(tempItem)) {
                return tempItem;
            }
        }
        throw new IllegalArgumentException("No such element in the stack: " + item);
    }

    @Override
    public int size() {
        return data.size();
    }
}

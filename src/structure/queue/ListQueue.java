package structure.queue;

import model.Queue;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListQueue<T> implements Queue<T> {

    private List<T> data;

    public ListQueue() {
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void enQueue(T item) {
        data.add(item);
    }

    @Override
    public T deQueue() {
        T result;
        if(CollectionUtils.isEmpty(data)) {
            throw new IllegalStateException("Cannot deQueue because the queue is empty");
        } else {
            result = data.get(0);
            data.remove(0);
        }
        return result;
    }

    @Override
    public boolean contains(T item) {
        for (T element : data) {
            if(element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T access(int position) {
        if(CollectionUtils.isEmpty(data)) {
            throw new IllegalArgumentException("No items in queue or position is greater");
        } else if (position < data.size()) {
            return data.get(position);
        } else {
            throw new IllegalArgumentException("Could not get queue item for position: " + position);
        }
    }

}

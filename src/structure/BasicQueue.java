package structure;

public class BasicQueue<T> {

    private static final int DATA_CAPACITY = 1000;

    private T[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(DATA_CAPACITY);
    }

    public BasicQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (T[]) new Object[size];
    }

    public int size() {
        if(front == -1 && end == -1) {
            return 0;
        } else {
            //gets inclusive subtraction value if front & end != -1
            return end - front + 1;
        }
    }

    public void enQueue(T item) {
        if((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full");
        } else if(size() == 0) {
            //check if first time adding element
            front++;
            data[++end] = item;
        } else {
            data[++end] = item;
        }
    }

    public T deQueue() {
        T item = null;
        if(size() == 0) {
            throw new IllegalStateException("Cannot deQueue because the queue is empty");
        } else if(front == end) {
            //check if this is the last item of the queue
            item = data[front];

            //gc purposes
            data[front] = null;

            front = -1;
            end = -1;
        } else {
            //grab the front of the queue, return it and adjust front pointer
            item = data[front];
            //gc purposes
            data[front] = null;

            front++;
        }
        return item;
    }

    public boolean contains(T item) {
        for (T element : data) {
            if(element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public T access(int position) {
        if(size() == 0 || position > size()) {
            throw new IllegalArgumentException("No items in queue or position is greater");
        }
        int trueIndex = 0;
        for (int i = front; i < end; i++) {
            if(trueIndex == position) {
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException("Could not get queue item for position: " + position);
    }

}

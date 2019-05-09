public class Stack {

    private int size = 0;
    private int capacity = 0;
    private Object[] stackArray;

    public Stack() {
        capacity = 10;
        stackArray = new Object[capacity];
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        stackArray = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object object) {

        if (size == capacity) {
            Object[] tempArray = new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                tempArray[i] = stackArray[i];
            }
            // used in kata solution on github
            // System.arraycopy(elements, 0, bigger, 0, elements.length);
            stackArray = tempArray;
        }

        stackArray[size] = object;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object object) {
        for (int i = 0; i < size; i++) {
            if (stackArray[i] == object) return true;
        }
        return false;
    }

    public Object peek() {
        if (isEmpty()) return null;

        return stackArray[size - 1];
    }

    public Object pop() {
        Object topObject = peek();

        if (!isEmpty()) {
            stackArray[size - 1] = null;
            size--;
        }

        return topObject;
    }


}


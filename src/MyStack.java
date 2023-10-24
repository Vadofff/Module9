public class MyStack {
    private Node top; // Вершина стеку
    private int size;  // Розмір колекції

    // Внутрішній клас для вузла
    private class Node {
        Object data; // Дані, які зберігає вузол
        Node next;   // Вказівник на наступний вузол

        public Node(Object data) {
            this.data = data;
        }
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            top = top.next;
        } else {
            Node current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

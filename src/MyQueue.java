public class MyQueue {
    private Node head; // Перший вузол
    private Node tail; // Останній вузол
    private int size;   // Розмір колекції

    // Внутрішній клас для вузла
    private class Node {
        Object data; // Дані, які зберігає вузол
        Node next;   // Вказівник на наступний вузол

        public Node(Object data) {
            this.data = data;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    public Object poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object value = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

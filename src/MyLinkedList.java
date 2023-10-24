public class MyLinkedList {
    private Node head; // Перший вузол
    private Node tail; // Останній вузол
    private int size;   // Розмір колекції

    // Внутрішній клас для вузла
    private class Node {
        Object data; // Дані, які зберігає вузол
        Node next;   // Вказівник на наступний вузол
        Node prev;   // Вказівник на попередній вузол

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
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node current = getNode(index);
        Node prevNode = current.prev;
        Node nextNode = current.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node node = getNode(index);
        return node.data;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

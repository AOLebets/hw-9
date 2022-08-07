import java.util.Collection;
import java.util.LinkedList;

public class MyLinkedList <E> {
    protected int size = 0;
    protected Node<E> first = null;
    protected Node<E> last = null;
    protected static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public String toString() {
        String result = "";
        Node pointer;
        if (this.first != null) {
            result += this.first.item.toString() + ", ";
            pointer = this.first.next;

            while (pointer != null) {
                result += pointer.item.toString() + ", ";
                pointer = pointer.next;
            }
        }
        return result.strip();
    }

    public void add(Object value) {
        Node addition = new Node(this.last, value, null);
        this.last = addition;
        if (addition.prev != null) { addition.prev.next = addition; }
        if (this.first == null) { this.first = addition; }
        size += 1;
    } // додає елемент в кінець

    public void remove(int index) {
        if (index < size) {
            Node pointer = getPointerByIndex(index);
            if (pointer.prev != null && pointer.next != null) {
                pointer.prev.next = pointer.next;
                pointer.next.prev = pointer.prev;
            } else if (pointer.prev != null) {
                pointer.prev.next = null;
                this.last = pointer.prev;
            } else if (pointer.next != null) {
                pointer.next.prev = null;
                this.first = pointer.next;
            } else {
                this.first = null;
                this.last = null;
            }
            size--;
        }
    } //видаляє елемент з вказаним індексом
    public void clear() {
        Node pointer = this.first;
        while (pointer != null) {
            pointer.prev = null;
            if (pointer.next != null) {
                pointer = pointer.next;
                pointer.prev.next = null;
            } else {
                pointer = null;
            }
        }
        this.first = null;
        this.last = null;
        size = 0;
    } //очищає колекцію
    public int size() {
        return size;
    }// повертає розмір колекції
    private Node getPointerByIndex(int index) {
        Node pointer = this.first;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public Object get(int index) {
        Node pointer = getPointerByIndex(index);
        return pointer.item;
    } //повертає елемент по індексу

}

public class MyStack extends  MyQueue{
    public void push(Object value) {
        Node addition = new Node(null, value, this.first);
        this.first = addition;
        if (addition.next != null) { addition.next.prev = addition; }
        if (this.last == null) { this.last = addition; }
        size += 1;
    } // додає елемент в початок (в завданні помилка, пуш не має додавати в кінець, це ж lifo)

    /* remove(int index) видаляє елемент по індексу
    clear() очищає колекцію
    size() повертає розмір колекції
    peek() повертає перший елемент стеку */

    public Object pop() {
        return this.poll();
    } // повертає перший елемент стеку та видаляє його з колекції
}

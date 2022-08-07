public class MyQueue extends MyLinkedList{

    /*add(Object value) додає елемент в кінець
    remove(int index) видаляє елемент по індексу
    clear() очищає колекцію
    size() повертає розмір колекції*/

    public Object peek() {
        return this.first.item;
    } //повертає перший елемент з черги

    public Object poll() {
        Object item = this.first.item;
        this.remove(0);
        return item;
    } // повертає перший елемент з черги і видаляє його з колекції

}

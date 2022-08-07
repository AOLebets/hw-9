public class MyHashMap <K, V> {

    protected int size = 0;
    protected MyHashMap.Node<K, V> first = null;
    protected static class Node<K, V> {
        K key;
        V value;
        MyHashMap.Node<K, V> next;

        Node(K key, V value, MyHashMap.Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;

        }
    }

    public String toString() {
        String result = "";
        MyHashMap.Node pointer;
        if (this.first != null) {
            result += "<" + this.first.key.toString() + ", " + this.first.value.toString() + ">, ";
            pointer = this.first.next;

            while (pointer != null) {
                result += "<" + pointer.key.toString() + ", " + pointer.value.toString() + ">, ";
                pointer = pointer.next;
            }
        } else {
            result = "empty";
        }
        return result.strip();
    }

    private Node findKey(K key) {
        Node result = null;
        Node pointer = this.first;
        if (this.first != null) {
            while (pointer != null) {
                if (pointer.key.hashCode() == key.hashCode()) {
                    result = pointer;
                    break;
                } else {
                    pointer = pointer.next;
                }

            }
        }
        return result;
    }

    private Node findPrevKey(K key) {
        Node pointer = this.first;
        Node prevPointer = null;
        if (pointer != null) {
            while (pointer != null) {
                if (pointer.key.hashCode() == key.hashCode()) {
                    break;
                } else {
                    prevPointer = pointer;
                    pointer = pointer.next;
                }

            }
        }
        return prevPointer;
    }
    public void put(Object key, Object value) {
        Node pointer = null;
        if (this.first == null) {
            this.first = new Node<K, V>((K) key, (V) value, null);
            size = 1;
        } else {
            pointer = findKey((K) key);
            if (pointer != null) {
                pointer.value = value;
            } else {
                Node newItem = new Node<K, V>((K) key, (V) value, this.first);
                this.first = newItem;
                size += 1;
            }
        }
    } //додає пару ключ + значення
    public void remove(Object key) {
        Node toRemove = findKey((K) key);
        Node previous = null;

        if (toRemove != null) {
            previous = findPrevKey((K) key);
            if (previous != null) {
                previous.next = toRemove.next;
            } else {
                this.first = toRemove.next;
            }
            size--;
        }
    } //видаляє пару по ключу
    public void clear() {
        Node pointer = this.first;
        Node prevPointer = null;
        while (pointer.next != null) {
            prevPointer = pointer;
            pointer = pointer.next;
            prevPointer.next = null;
        }
        pointer = null;
        prevPointer = null;
        this.first = null;
        this.size = 0;
    }//очищає колекцію
    public int size() {
        return size;
    }//повертає розмір колекції
    public Object get(Object key) {
        return findKey((K) key).value;
    }//повертає значення (Object value) по ключу

}

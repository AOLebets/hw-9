import java.util.*;

public class MyArrayList<E> {

    private int size = 0;
    private Object[] myArrList = {};

    void add(Object value) {
        Object[] temp = myArrList;
        myArrList = new Object[myArrList.length+1];
        //myArrList = Arrays.copyOf(temp, size);
        System.arraycopy(temp, 0, myArrList, 0, size);
        myArrList[size] = value;
        size = myArrList.length;
    }

    void clear() {
        myArrList = new Object[0];
        size = 0;
    }

    int size() {
        return size;
    }

    Object get(int index){
        return myArrList[index];
    } //повертає елемент по індексу

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < myArrList.length; i++) {
            result += myArrList[i].toString() + ";" ;
        }
        return result;
    }
 /*   ArrayList(Collection<? extends E> c)
    Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
    ArrayList(int initialCapacity)

    void add(Object value) {
        Object[] newArrList = Arrays.copyOf(ArrList, ArrList.length+1);
        newArrList[ArrList.length+1] = value;
        ArrList = Arrays.copyOf(newArrList, newArrList.length);
    } //додає елемент в кінець

    void remove(int index){
        Object[] newArrList = new Object[ArrList.length];
        for (int i = 0; i < ArrList.length-1; i++) {
            if( i != index) {
                newArrList[i] = ArrList[i];
            }
        }

    } //видаляє елемент з вказаним індексом
    void clear(){

    } //очищає колекцію
    int size() {
        int result = 1;
        return result;
    } //повертає розмір колекції

    @Override

    */

}

package Lesson3.Homework.Task1;

/*
1. Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 */

public class MyCollection<T> {
    private Object[] storage;
    int strLength;
    MyIterator iterator;

    MyCollection() {
        storage = new Object[1];
        strLength = 1;
        iterator = new MyIterator();
    }

    public void add(T t) {
        Object[] temp = new Object[strLength + 1];
        System.arraycopy(storage, 0, temp, 0, strLength);
        temp[strLength - 1] = t;
        this.storage = temp;
        strLength++;
    }

    public void delete(T t) {
        if (find(t) != null) {
            Object[] temp = new Object[strLength - 1];
            Integer delIndex = find(t);

            for (int i = 0; i < strLength - 1; i++) {
                if (delIndex > i) temp[i] = storage[i];
                else temp[i] = storage[i + 1];
            }
            this.storage = temp;
            strLength--;
        }

    }

    public Integer find(T t) {
        for (int i = 0; i < strLength; i++) {
            if (storage[i].equals(t)) return i;
        }
        return null;
    }


    public class MyIterator {

        private Integer index;

        MyIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < storage.length;
        }

        public Object next() {
            if (hasNext()) {
                Object temp = storage[index];
                index++;
                return temp;
            }
            return null;
        }



    }

    public static void main(String[] args) {
        MyCollection<Object> my = new MyCollection<Object>();
        String a = "dfdd";
        String f = "DFDF";
        Integer b = 12;
        my.add(a);
        my.add(f);
        my.add(b);
        System.out.println(my.iterator.next());
        System.out.println(my.iterator.next());
        System.out.println(my.iterator.next());
        System.out.println(my.iterator.next());
        System.out.println(my.iterator.hasNext());
        for (int i = 0; i < my.storage.length - 1; i++) {
            System.out.println(my.storage[i]);
        }
    }

}
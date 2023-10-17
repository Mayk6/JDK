package Lesson3.Homework.Task4;

//4. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
//   Класс должен иметь методы getFirst(), getSecond() для получения значений пары,
//   а также переопределение метода toString(), возвращающее строковое представление пары.

import java.sql.Time;

public  class Pair <T, V> {

    private T key;
    private V value;

    Pair(T t, V v) {
        this.key = t;
        this.value = v;
    }

    public T getFirst() {
        return key;
    }

    public V getSecond() {
        return value;
    }

    @Override
    public String toString() {
        return "Пара: " +
                "ключ: " + key +
                ", значение: " + value;
    }

    public static void main(String[] args) {
        Integer a = 1;
        String b = "ffd";
        Time dateTime = new Time(12);
        Pair pair = new Pair(a,dateTime);

        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair);
    }
}

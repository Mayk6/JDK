package Lesson3.Homework.Task2;


//2. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
//   Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.

public class Calculator {

    public static <T, V> void sum(T t, V v)  {
        System.out.println(Double.parseDouble(t.toString()) + Double.parseDouble(v.toString()));
    }

    public static <T, V> void multiply(T t, V v)  {
        System.out.println(Double.parseDouble(t.toString()) * Double.parseDouble(v.toString()));
    }

    public static <T, V> void divide(T t, V v)  {
        System.out.println(Double.parseDouble(t.toString()) / Double.parseDouble(v.toString()));
    }

    public static <T, V> void subtract(T t, V v)  {
        System.out.println(Double.parseDouble(t.toString()) - Double.parseDouble(v.toString()));
    }

    public static void main(String[] args) {
        Double a = 1.2;
        Float b = 3.4f;
        sum(a, b);
        subtract(b,a);
        multiply(a,b);
        divide(b,a);
    }
}

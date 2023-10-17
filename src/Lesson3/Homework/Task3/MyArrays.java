package Lesson3.Homework.Task3;

//3. Напишите обобщенный метод compareArrays(), который принимает два массива и
//   возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
//   любого типа данных, но должны иметь одинаковую длину и содержать элементы одного
//   типа.

import java.util.Objects;

public class MyArrays {

    public static <T, V> boolean compareArrays(T[] arr1, V[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Массивы не могут быть разного размера");
            return false;
        }
        if (!checkArrType(arr1, arr2)) {
            System.out.println("Массивы должны содержать элементы одного типа");
            return false;
        }


        if (Character.isDigit((arr1[0].toString()).toCharArray()[0])) {
            for (int i = 0; i < arr1.length; i++) {
                Double temp1 = Double.parseDouble(arr1[i].toString());
                Double temp2 = Double.parseDouble(arr2[i].toString());
                if (!temp1.equals(temp2)) return false;
            }
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) return false;
            }
        }

        return true;

    }

    public static <T, V> boolean checkArrType(T[] arr1, V[] arr2) {
        String type = arr1[0].getClass().toString();
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].getClass().toString().equals(type) || !arr2[i].getClass().toString().equals(type))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        Integer[] b = {1, 2, 3, 4, 5};
        Double[] c = {1.0, 2.0, 3.0, 4.0, 5.0};
        Double[] d = {1.2, 3.2, 3.3};
        Float[] e = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        String[] f = {"sssd", "s", "d", "s", "f"};
        String[] g = {"sssd", "s", "d", "s", "f"};

        System.out.println(compareArrays(g, f));
    }
}

package Lesson4.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class EmployeeDir {

    private final ArrayList<Employee> directory;

    public EmployeeDir() {
        this.directory = new ArrayList<>();
    }

    public void findBySeniority(Integer year) {
        var temp = directory.stream().filter(employee -> Objects.equals(employee.getSeniority(), year)).map(Employee::toString).toArray(String[]::new);
        System.out.println(Arrays.toString(temp));
    }

    public void findPhoneByName(String name) {
        var temp = directory.stream().filter(employee -> employee.getName().equalsIgnoreCase(name))
                .map(Employee::getPhone).toArray(String[]::new);
        System.out.println(Arrays.toString(temp));

    }

    public void add(Employee employee) {
        directory.add(employee);
    }

    public void findById(Integer id) {
        System.out.println(directory.stream().filter(employee -> Objects.equals(employee.getId(), id)).findAny());
    }

    public static void main(String[] args) {
        Employee q = new Employee("Илья", "+777", 5);
        Employee w = new Employee("Вася", "+888", 5);
        Employee e = new Employee("Илья", "+999", 3);
        Employee r = new Employee("Петя", "+666", 2);
        EmployeeDir dir = new EmployeeDir();
        dir.add(q);
        dir.add(w);
        dir.add(e);
        dir.add(r);
        System.out.println(dir.directory);
        dir.findById(2);
        dir.findPhoneByName("Илья");
        dir.findBySeniority(5);
    }
}

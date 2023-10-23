package Lesson4.Homework;

public class Employee {

    private static Integer ID = 0;
    private final Integer id;
    private final String name;
    private String phone;
    private Integer seniority;

    public Employee(String name, String phone, Integer seniority) {
        this.id = ID;
        this.name = name;
        this.phone = phone;
        this.seniority = seniority;
        ID++;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Сотрудник (" +
                "id= " + id +
                ", Имя='" + name + '\'' +
                ", Телефон='" + phone + '\'' +
                ", Стаж=" + seniority +
                ") \n";
    }
}

package Lesson2.Seminar.DevTeam;

public interface Developer {

    default void smoke() {
        System.out.println("Вышел покурить");
    }

}

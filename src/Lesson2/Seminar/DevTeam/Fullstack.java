package Lesson2.Seminar.DevTeam;

public class Fullstack {


    public static void main(String[] args) {
        Developer dev = new Front() {
            @Override
            public void developGUI() {
                System.out.println("Разрабатывает интерфейс");
            }
        };
        if (dev instanceof Front) {
            ((Front) dev).developGUI();
        }
    }


}

package Lesson5.Homework;

public class Philosophers extends Thread{

    private String name;
    private boolean hungry;
    private int count = 0;

    private Object monitor = Philosophers.class;

    public Philosophers(String name) {
        this.name = name;
    }

    public void think() {
        System.out.println("Философ " + name + " думает");
        hungry = true;
    }

    public void eat() throws InterruptedException {
        if (hungry) {
            if (count < 3) {
                System.out.println("Философ " + name + " кушает");
                Thread.sleep(500);
                count++;
                hungry = false;
            } else {
                Thread.currentThread().stop();
            }
        }
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {
            synchronized (monitor) {
                think();
            }
            try {
                synchronized (monitor) {
                    eat();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Philosophers p1 = new Philosophers("Доби");
        Philosophers p2 = new Philosophers("Коби");
        Philosophers p3 = new Philosophers("Моби");
        Philosophers p4 = new Philosophers("Роби");
        Philosophers p5 = new Philosophers("Дроби");

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }






}

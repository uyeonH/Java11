package thread;

import javax.swing.*;

public class ThreadEx8 {
    public static void main(String[] args) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();

        // 쓰레드 우선순위

        //th2가 우선순위가 높다
        th2.setPriority(7);

        System.out.println("th1.getPriority() = " + th1.getPriority());  // 디폴트 5
        System.out.println("th2.getPriority() = " + th2.getPriority());

        th1.start();
        th2.start();
    }

}

class ThreadEx8_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++) {

            }
        }
    }

}

class ThreadEx8_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int x = 0; x < 10000000; x++) {

            }
        }
    }

}
package thread;

import javax.swing.*;

public class ThreadEx7 {
    public static void main(String[] args) {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값 입력: ");
        System.out.println("input = " + input);
    }

}

class ThreadEx7_1 extends Thread {
    public void run() {
        for (int i = 10; i >0; i--) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}
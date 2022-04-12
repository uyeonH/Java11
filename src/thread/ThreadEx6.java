package thread;

import javax.swing.*;

public class ThreadEx6 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값 입력: ");
        System.out.println("input = " + input);

        // 사용자가 값을 입력하면 아래 코드가 실행됨
        for (int i = 10; i >0; i--) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}

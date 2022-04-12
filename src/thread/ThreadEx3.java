package thread;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
        // 예외가 발생되자 main 스레드도 정상 종료되지 않았다.
        // 새로운 스레드가 생성되지 않은 것이다.
    }

}

class ThreadEx3_1 extends Thread{
    public void run() {
        throwException();
    }
    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace(); // 예외가 발생한 당시의 호출 스택 출력
        }
    }
}
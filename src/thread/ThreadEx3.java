package thread;

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
    }

}
class ThreadEx2_1 extends Thread{
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
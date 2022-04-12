package thread;

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
        // 예외가 발생해도 다른 스레드에 영향을 미치지 않는다.
        // 따라서 호출 스택에 main은 정상적으로 종료되었다.
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
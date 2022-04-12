package lambda;

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}

public class LambdaEx2 {

    public static void main(String[] args) {

        MyFunction2 f = () -> {
        };
        System.out.println("f = " + f);

        Object obj = (MyFunction2) (() -> {
        });
        System.out.println("obj = " + obj);

        String str= ((Object)(MyFunction2)(() -> {
        })).toString();
        System.out.println("str = " + str);

        System.out.println((MyFunction2)(()->{}));
        System.out.println((Object)(MyFunction2)(()->{}));
        //System.out.println((Object)(()->{})); // 에러

    }
}

package lambda;


public class LambdaEx3 {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);

    }
}

class Outer {
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i) {
            int val = 30;
            // 람다식 내에서 참조하는 지역변수는 final이 없어도 상수로 간주
 //           i = 10; // 상수 값 변경 불가

            MyFunction2 f = () ->
            {
                //System.out.println("i = " + i);
                System.out.println("val = " + val);
                System.out.println("++this.val = " + ++this.val);
                System.out.println("++Outer.this.val = " + ++Outer.this.val);
            };
            f.myMethod();
        }
    }
}
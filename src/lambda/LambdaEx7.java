package lambda;

import java.util.Arrays;
import java.util.function.*;

public class LambdaEx7 {
    public static void main(String[] args) {

        Function<String, Integer> f = s -> Integer.parseInt(s, 16);
        Function<Integer, String> g = i -> Integer.toBinaryString(i);

        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);


        System.out.println(h.apply("FF"));
        System.out.println(h2.apply(2));

    }


}

package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx1 {

    public static void main(String[] args) {
        Stream<Student> stream = Stream.of(
                new Student("A", 3, 100)
                , new Student("B", 2, 200)
                , new Student("C", 3, 300)
                , new Student("D", 1, 200)
                , new Student("E", 4, 5)
        );
        stream.sorted(Comparator
                .comparing(Student::getBan) // 반별 정렬
                .thenComparing(Comparator.naturalOrder())) // 기본 정렬
                .forEach(System.out::println);

    }
}


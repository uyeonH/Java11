package stream;

import java.io.File;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("A", 3, 100)
                , new Student("B", 2, 200)
                , new Student("C", 3, 300)
                , new Student("D", 1, 200)
                , new Student("E", 4, 5)
        };
        Stream<Student> stream = Stream.of(stuArr);
        stream.sorted(Comparator
                .comparing(Student::getBan) // 반별 정렬
                .thenComparing(Comparator.naturalOrder())) // 기본 정렬
                .forEach(System.out::println);

        stream = Stream.of(stuArr);
        IntStream scoreStream = stream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = scoreStream.summaryStatistics();

        System.out.println("count = " + stat.getCount());
        System.out.println("sum = " + stat.getSum());
        System.out.println("avg = " + stat.getAverage());
        System.out.println("min = " + stat.getMin());
        System.out.println("max = " + stat.getMax());
    }
}

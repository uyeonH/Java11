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

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.ban = ban;
        this.name = name;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
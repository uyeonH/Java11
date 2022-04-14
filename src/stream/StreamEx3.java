package stream;

import java.io.File;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx2 {

    public static void main(String[] args) {
        File[] fileArr = {
                new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex1.txt")
        };

        Stream<File> fileStream = Stream.of(fileArr);

        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(System.out::println);

        fileStream = Stream.of(fileArr); // 스트림 재생성
        System.out.println();
        fileStream.map(File::getName)
                .filter(s->s.indexOf(".")!=-1) // 확장자 없는 것 제외
                .map(s->s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .map(String::toUpperCase) // 대문자화
                .distinct() // 중복제거
                .forEach(System.out::println);
    }
}

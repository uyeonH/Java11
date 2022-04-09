package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy = "yooyeon",testDate = @DateTime(yymmdd="220409",hhmmss="231313"))
public class AnnotationEx5 {
    public static void main(String args[]) {
        Class<AnnotationEx5> cls = AnnotationEx5.class;
        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate() = " + anno.testDate().hhmmss());

        for (String s : anno.testTools()) {
            System.out.println("tools=" + s);
        }
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
    }


}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
    int count() default 1;

    String testedBy();

    String[] testTools() default "JUnit";

    TestType testType() default TestType.FIRST;

    DateTime testDate();

}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();

    String hhmmss();
}
enum TestType{
    FIRST, FINAL
}
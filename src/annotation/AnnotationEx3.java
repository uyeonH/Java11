package annotation;

import java.util.ArrayList;
import java.lang.annotation.Repeatable;
public class AnnotationEx3 {

    @SuppressWarnings("deprecation")
    public static void main(String args[]) {
        NewClass nc = new NewClass();
        nc.oldField = 10;
        System.out.println("nc.getOldField() = " + nc.getOldField());

        @SuppressWarnings("unchecked")
        ArrayList<NewClass> list = new ArrayList(); // 타입을 지정하지 않음
        list.add(nc);
    }

}


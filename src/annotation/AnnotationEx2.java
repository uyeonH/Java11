package annotation;

public class AnnotationEx2 {
    public static void main(String args[]) {
        NewClass nc = new NewClass();
        nc.oldField = 10;
        System.out.println("nc.getOldField() = " + nc.getOldField());
    }

}


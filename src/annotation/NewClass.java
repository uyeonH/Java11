package annotation;

class NewClass {
    int newField;

    public int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    public int getOldField() {
        return oldField;
    }
}

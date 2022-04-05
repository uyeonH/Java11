package generics;

class Fruit implements Etable {
    String name;
    int weight;
    public Fruit() {

    }
    public Fruit(String name) {
        this.name = name;

    }

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n(name=" + name + ", weight=" + weight + ")";
    }
}

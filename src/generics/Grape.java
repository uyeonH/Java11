package generics;

class Grape extends Fruit {
    Grape(){

    }
    Grape(String name) {
        super(name);
    }
    Grape(String name, int weight) {
        super(name,weight);
    }
    @Override
    public String toString() {
        return "\n(name=" + name + ", weight=" + weight + ")";
    }
}

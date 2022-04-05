package generics;

class Apple extends Fruit {
    Apple() {

    }

    Apple(String name) {
        super(name);
    }

    Apple(String name, int weight) {
        super(name, weight);
    }

    @Override
    public String toString() {
        return "\n(name=" + name + ", weight=" + weight + ")";
    }
}

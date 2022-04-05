package generics;

class Juice {
    String name;

    Juice(String name) {
        this.name = name + "Juice";
    }

    @Override
    public String toString() {
        return name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box) { // 와일드카드, Fruit의 자식
        String tmp = "";
        for (Fruit f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        System.out.println("fruitBox = " + fruitBox);
        appleBox.add(new Apple());

        System.out.println("Juicer.makeJuice(fruitBox) = " + Juicer.makeJuice(fruitBox));
        System.out.println("Juicer.makeJuice(appleBox) = " + Juicer.makeJuice(appleBox));
    }
}

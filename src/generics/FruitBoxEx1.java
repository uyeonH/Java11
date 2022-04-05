package generics;

import java.util.ArrayList;

public class FruitBoxEx1 {
    public static void main(String[] args) {

        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
    }

}


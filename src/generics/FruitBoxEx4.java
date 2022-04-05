package generics;

import java.util.Collections;
import java.util.Comparator;

public class FruitBoxEx4 {
    public static void main(String[] args) {
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();

        appleBox.add(new Apple("GreenApple", 300));
        appleBox.add(new Apple("GreenApple", 100));
        appleBox.add(new Apple("GreenApple", 200));

        grapeBox.add(new Grape("GreenGrape", 200));
        grapeBox.add(new Grape("GreenGrape", 300));
        grapeBox.add(new Grape("GreenGrape", 400));


        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());

        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
    }

}

class AppleComp implements Comparator<Apple> {
    @Override
    public int compare(Apple t1, Apple t2) {
        return t1.weight - t2.weight;
    }
}

class GrapeComp implements Comparator<Grape> {
    @Override
    public int compare(Grape t1, Grape t2) {
        return t1.weight - t2.weight;
    }
}

class FruitComp implements Comparator<Fruit> {
    @Override
    public int compare(Fruit t1, Fruit t2) {
        return t1.weight - t2.weight;
    }
}

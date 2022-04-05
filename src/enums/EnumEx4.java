package enums;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    int ordinal;
    String name = "";

    public int ordinal() {
        return ordinal;
    }

    MyEnum(String name) {
        this.name = name;
        ordinal = id++;
    }

    public int compareTo(T t) {
        return ordinal - t.ordinal;
    }
}


abstract class MyTransportation extends MyEnum {
    static final MyTransportation BUS = new MyTransportation("BUS", 100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    protected final int BASIC_FARE;

    private MyTransportation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }

    abstract int fare(int distance);

    public String name() {
        return name;
    }

    public String toString() {
        return name;
    }
}

public class EnumEx4 {
    public static void main(String[] args) {
        MyTransportation bus = MyTransportation.BUS;
        MyTransportation bus2 = MyTransportation.BUS;
        MyTransportation train = MyTransportation.TRAIN;
        MyTransportation ship = MyTransportation.SHIP;

        System.out.printf("bus=%s, %d%n", bus.name, bus.ordinal);
        System.out.printf("bus2=%s, %d%n", bus2.name, bus2.ordinal);
        System.out.printf("train=%s, %d%n", train.name, train.ordinal);
        System.out.printf("ship=%s, %d%n", ship.name, ship.ordinal);
        System.out.println("(bus == bus2) = " + (bus == bus2));
        System.out.println("bus.compareTo(train) = " + bus.compareTo(train));
    }
}

package enums;

public enum Transportation {
    BUS(100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    TRAIN(150) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    SHIP(100) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    AIRPLANE(300) {
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    protected final int BASIC_FARE;

    Transportation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }

    abstract int fare(int distance);

}

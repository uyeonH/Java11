package enums;

public class EnumEx3 {
    public static void main(String[] args) {
        // enum 추상메서드
        System.out.println("BUS fare="+Transportation.BUS.fare(100));
        System.out.println("TRAIN fare="+Transportation.TRAIN.fare(100));
        System.out.println("SHIP fare="+Transportation.SHIP.fare(100));
        System.out.println("AIRPLANE fare="+Transportation.AIRPLANE.fare(100));
    }
}

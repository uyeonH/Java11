package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class NewTimeEx4 {
    public static void main(String[] args) {

        // 날짜와 시간 비교

        LocalDate today = LocalDate.now();

        LocalDate birthDate = LocalDate.of(1996, 5, 8);

        System.out.println(today.isAfter(birthDate));
        System.out.println(birthDate.isBefore(today));
        System.out.println(today.isEqual(birthDate));



    }
}

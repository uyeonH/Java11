package time;

import java.time.*;

public class NewTimeEx {
    public static void main(String[] args) {
        // Calendar는 예전부터 많이 사용되어 왔지만 멀티쓰레드 환경에서 안전하지 못하다.
        // jdk1.8부터 추가된 java.time은 쓰레드에 안전하다.

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime dateTimeInKr = ZonedDateTime.now();

        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);
        System.out.println("dateTimeInKr = " + dateTimeInKr);

        LocalDate date2 = LocalDate.of(2022, 04, 02);
        LocalTime time2 = LocalTime.of(23, 59, 59);
        LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime2, ZoneId.of("Asia/Seoul"));

        System.out.println("date2 = " + date2);
        System.out.println("time2 = " + time2);
        System.out.println("dateTime2 = " + dateTime2);
        System.out.println("zonedDateTime = " + zonedDateTime);



    }
}

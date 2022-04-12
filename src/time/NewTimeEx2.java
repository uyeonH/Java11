package time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx2 {
    public static void main(String[] args) {

        // TemporalUnit 인터페이스 날짜 시간 정의
        // 열거형 ChronoUnit 구현

        LocalTime now = LocalTime.now();
        int minute = now.getMinute();

        // ChronoField.MINUTE_OF_HOUR -> TemporalField
        int minute2 = now.get(ChronoField.MINUTE_OF_HOUR);

        LocalDate today = LocalDate.now();

        // ChronoUnit.DAYS -> TemporalUnit
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate tomorrow2 = today.plusDays(1);


    }
}

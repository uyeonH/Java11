package time;

import java.time.*;
import java.time.temporal.ChronoField;

public class NewTimeEx5 {
    public static void main(String[] args) {

        // LocalDate + LocalTime -> LocalDateTime
        // LocalDateTime + Time Zone -> ZonedDateTime
        LocalDateTime dt = LocalDateTime.of(2022, 4, 2, 17, 5, 55);
        dt = LocalDateTime.now();
        LocalDate localDate = dt.toLocalDate();
        LocalTime localTime = dt.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);


        ZoneId id = ZoneId.of("Asia/Seoul");
        ZonedDateTime zonedDateTime = dt.atZone(id);
        System.out.println("zonedDateTime = " + zonedDateTime);


        //ZoneOffset: UTC로부터 얼마만큼 떨어져 있는지 표현

        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
        System.out.println("nyTime = " + nyTime);

        ZoneOffset krOffset = ZonedDateTime.now().getOffset();
        int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);
        System.out.println("krOffsetInSec = " + krOffsetInSec);

        OffsetDateTime odt = zonedDateTime.toOffsetDateTime();
        System.out.println("odt = " + odt);

    }
}

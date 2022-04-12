package time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class NewTimeEx6 {
    public static void main(String[] args) {

        // Period와 Duration
        LocalDate date1 = LocalDate.of(2022, 3, 2);
        LocalDate date2 = LocalDate.of(2023, 12, 1);

        Period p = Period.between(date1, date2);
        System.out.println("YEAR = " + p.get(ChronoUnit.YEARS));
        System.out.println("MONTH = " + p.get(ChronoUnit.MONTHS));
        System.out.println("DAY = " + p.get(ChronoUnit.DAYS));

        LocalTime time1 = LocalTime.of(0, 0, 0);
        LocalTime time2 = LocalTime.of(12, 12, 12);
        Duration d = Duration.between(time1, time2);

        LocalTime tmp = LocalTime.of(0, 0).plusSeconds(d.getSeconds());
        System.out.println("HOUR = " + tmp.getHour());
        System.out.println("MIN = " + tmp.getMinute());
        System.out.println("SECOND = " + tmp.getSecond());

    }
}

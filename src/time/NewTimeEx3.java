package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx3 {
    public static void main(String[] args) {

        LocalDate birthDate = LocalDate.of(1996, 5, 8);
        LocalTime birthTime = LocalTime.of(23, 59, 59);
        LocalTime.of(23, 59, 59, 59);

        // Calendar와 달리 월 범위가 1~12, 요일은 월(1)~일(7)

        int year = birthDate.getYear();
        int month = birthDate.getMonthValue();
        Month monthName = birthDate.getMonth();
        int dayOfMonth = birthDate.getDayOfMonth();
        int dayOfYear = birthDate.getDayOfYear();
        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();

        int lengthOfMonth = birthDate.lengthOfMonth();
        int lengthOfYear = birthDate.lengthOfYear();
        boolean leapYear = birthDate.isLeapYear();


        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("monthName = " + monthName);
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("dayOfYear = " + dayOfYear);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("lengthOfMonth = " + lengthOfMonth);
        System.out.println("lengthOfYear = " + lengthOfYear);
        System.out.println("leapYear = " + leapYear);

        int hour = birthTime.getHour();
        int minute = birthTime.getMinute();
        int second = birthTime.getSecond();
        int nano = birthTime.getNano();

        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("nano = " + nano);


        // 날짜, 시간의 특정 필드 변경은 with로 시작하는 메서드 사용
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        today=today.withYear(2023);
        now=now.withHour(10);

        System.out.println("today = " + today);
        System.out.println("now = " + now);

    }
}

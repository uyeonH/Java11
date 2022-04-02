package calendar;

import java.util.Calendar;

public class CalendarEx5 {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        date.set(2022, 0, 31);
        System.out.println("date = " + toString(date));
        date.roll(Calendar.MONTH, 1);
        System.out.println("date = " + toString(date)); // 한달 뒤 2월 31일은 없으므로 2월 28일 출력
        date.roll(Calendar.MONTH, 1);
        System.out.println("date = " + toString(date));
    }
    private static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}

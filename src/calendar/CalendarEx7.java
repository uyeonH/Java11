package calendar;

import java.util.Calendar;

public class CalendarEx7 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("args (ex) 2022 4");
            return;
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        System.out.println("year = " + year);
        System.out.println("month = " + month);

        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar sDay = Calendar.getInstance(); // 시작 날짜
        Calendar eDay = Calendar.getInstance(); // 끝 날짜

        sDay.set(year, month - 1, 1); // 월 인덱스로 1 빼줌
        eDay.set(year, month - 1, sDay.getActualMaximum(Calendar.DATE)); // 말일

        sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1); // 3월 27일이 된다
        eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK)); // 그대로 4월 30일이다

        System.out.println("      " + args[0] + "년 " + args[1] + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        for (int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
            int day = sDay.get(Calendar.DATE);
            System.out.print((day < 10) ? "  " + day : " " + day);
            if (n++ % 7 == 0) {
                System.out.println();
            }
        }
    }
}

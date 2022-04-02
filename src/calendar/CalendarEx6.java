package calendar;

import java.util.Calendar;

public class CalendarEx6 {
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
        eDay.set(year, month, 1); // 말일 계산 다음달 - 1일
        eDay.add(Calendar.DATE, -1);

        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK); // 첫번째 요일
        END_DAY = eDay.get(Calendar.DATE); // 끝 날짜

        System.out.println("      " + args[0] + "년 " + args[1] + "월");
        for (int i = 1; i < START_DAY_OF_WEEK; i++) {
            System.out.print("   ");
        }
        for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
            System.out.print((i<10)? "  "+i: " "+i);
            if (n % 7 == 0) {
                System.out.println();
            }
        }
    }
}

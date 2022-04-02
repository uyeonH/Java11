package calendar;

public class CalendarEx9 {
    public static void main(String[] args) {
        // 직접 구현해보기

        System.out.println("(2022,5,8) = " + getDayOfWeek(2022, 5, 8));
        System.out.println("(2021,4,2) = " + getDayOfWeek(2022, 4, 2));
        System.out.println("(2022,5,8) - (2021,4,2) = " + dayDiff(2022, 5, 8, 2021, 4, 2) + "일");
        System.out.println("(2022,03,15)" + convertDateToDay(2022, 03, 15));
        System.out.println("737739 = " + convertDayToDate(737739));
    }

    private static String convertDayToDate(int day) {

        int year = 1;
        int month = 0;

        while (true) {
            int aYear = isLeapYear(year) ? 366 : 365;
            if (day > aYear) {
                day -= aYear;
                year++;
            } else {
                break;
            }
        }
        while (true) {
            int endDay = endOfMonth[month];
            if (isLeapYear(year) && month == 1) endDay++; // 윤년, 윤달이면 1 더하기
            if (day > endDay) {
                day -= endDay;
                month++;
            } else break;
        }
        return year + "." + (month + 1) + "." + day;
    }

    private static int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2) {
        return convertDateToDay(y1, m1, d1) - convertDateToDay(y2, m2, d2);
    }

    public static int[] endOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static int getDayOfWeek(int year, int month, int day) {
        return convertDateToDay(year, month, day) % 7 + 1;
    }

    private static int convertDateToDay(int year, int month, int day) {
        int numOfLeapYear = 0;
        // 전년도까지 윤년의 수
        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) numOfLeapYear++;
        }
        //전년도까지의 일수
        int toLastYearDaySum = (year - 1) * 365 + numOfLeapYear;

        //올해의 현재 월까지의 일수 계산
        int thisYearDaySum = 0;

        for (int i = 0; i < month - 1; i++) {
            thisYearDaySum += endOfMonth[i];
        }

        //윤년이고 2월이 포함되어 있으면 1일을 증가시킨다
        if (month > 2 && isLeapYear(year))
            thisYearDaySum++;

        thisYearDaySum += day;

        return toLastYearDaySum + thisYearDaySum;

    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) && year % 400 == 0);
    }
}

import java.util.Calendar;

public class CalendarEx2 {
    public static void main(String[] args) {

        final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        //date1.set(2022, 3, 1); 인덱스 0부터 시작
        date1.set(2022, Calendar.MARCH, 1);
        System.out.println("DATE1 = " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일");
        System.out.println("DATE2(오늘) = " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일");

        //두 날짜 간의 차이
        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
        System.out.println("date1에서 date2(오늘)까지 " + difference + "초 지남");
        System.out.println("date1에서 date2(오늘)까지 일로 계산하면 " + difference / (24 * 60 * 60) + "일 지남");
    }

    private static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}

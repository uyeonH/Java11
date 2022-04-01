import java.util.Calendar;

public class CalendarEx {
    public static void main(String[] args) {

        //Calendar는 추상클래스이기 때문에 직접 객체 생성이 불가능하다.
        //Calendar cal = new Calendar();

        Calendar today = java.util.Calendar.getInstance();
        System.out.println("년 = " + today.get(Calendar.YEAR));
        System.out.println("월(0~11, 0: 1월) = " + today.get(Calendar.MONTH));
        System.out.println("이 해의 몇째 주 = " + today.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇째주 = " + today.get(Calendar.WEEK_OF_MONTH));
        System.out.println("오늘 날짜 = " + today.get(Calendar.DATE));
        System.out.println("오늘 날짜 = " + today.get(Calendar.DAY_OF_MONTH));
        System.out.println("이 해의 몇일 = " + today.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일 (1:일요일) = " + today.get(Calendar.DAY_OF_WEEK));
        System.out.println("이 달의 몇째 요일 = " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("오전_오후(0: 오전, 1: 오후) = " + today.get(Calendar.AM_PM));
        System.out.println("시간(0~11) = " + today.get(Calendar.HOUR));
        System.out.println("시간(0~23) = " + today.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59) = " + today.get(Calendar.MINUTE));
        System.out.println("초(0~59) = " + today.get(Calendar.SECOND));
        System.out.println("밀리초(0~999) = " + today.get(Calendar.MILLISECOND));
        System.out.println("이 달의 마지막 날 = " + today.getActualMaximum(Calendar.DATE));






    }
}

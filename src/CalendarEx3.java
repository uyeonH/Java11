import java.util.Calendar;

public class CalendarEx3 {
    public static void main(String[] args) {

        final int[] TIME_UNIT = {3600, 60, 1};
        final String[] TIME_UNIT_NAME = {"시간", "분", "초"};

        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();

        // 11시 44분 0초
        time1.set(Calendar.HOUR_OF_DAY, 11);
        time1.set(Calendar.MINUTE, 44);
        time1.set(Calendar.SECOND, 0);

        // 21시 10분 30초
        time2.set(Calendar.HOUR_OF_DAY, 21);
        time2.set(Calendar.MINUTE, 10);
        time2.set(Calendar.SECOND, 30);

        System.out.println("time1 = "
                + time1.get(Calendar.HOUR_OF_DAY) + "시 "
                + time1.get(Calendar.MINUTE) + "분 " +
                time1.get(Calendar.SECOND) + "초 ");
        System.out.println("time2 = "
                + time2.get(Calendar.HOUR_OF_DAY) + "시 "
                + time2.get(Calendar.MINUTE) + "분 " +
                time2.get(Calendar.SECOND) + "초 ");

        long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
        System.out.println("diff = " + diff + "초");
        String tmp = "";
        for (int i = 0; i < TIME_UNIT.length; i++) {
            tmp += diff / TIME_UNIT[i] + TIME_UNIT_NAME[i];
            diff %= TIME_UNIT[i];
        }
        System.out.println("시분초로 변환 = " + tmp);
    }
}

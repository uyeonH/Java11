package calendar;

public class CalendarEx8 {
    public static void main(String[] args) {

        // 년, 월 정도의 계산은 굳이 Calendar를 사용할 필요 없다.

        String date1 = "202203";
        String date2 = "202101";

        int month1 = Integer.parseInt(date1.substring(0, 4)) * 12 + Integer.parseInt(date1.substring(4));
        int month2 = Integer.parseInt(date2.substring(0, 4)) * 12 + Integer.parseInt(date2.substring(4));

        //System.out.println("Integer.parseInt(date1.substring(0, 4)) * 12 = " + Integer.parseInt(date1.substring(0, 4)) * 12);
        //System.out.println("Integer.parseInt(date1.substring(4) = " + Integer.parseInt(date1.substring(4)));
        
        System.out.println(Math.abs(month1 - month2) + "개월 차이");
    }
}

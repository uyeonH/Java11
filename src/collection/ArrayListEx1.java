package collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList(10);

        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ArrayList list2 = new ArrayList(list.subList(1, 3));
        print(list, list2);

        Collections.sort(list);
        Collections.sort(list2);

        print(list, list2);
        System.out.println("list.containsAll(list2) = " + list.containsAll(list2));
        System.out.println("list2.containsAll(list) = " + list2.containsAll(list));
        list2.add("A");
        list2.add("B");
        list2.add(3, "C");
        print(list, list2);

        //list2와 겹치는 부분만 남기기
        System.out.println("list.retainAll(list2) = " + list.retainAll(list2));
        print(list, list2);

        // 앞에서부터 지우면 빈 공간을 채우기 위해 요소들이 자리 이동을 하므로
        // 뒤에서부터 체크
        for (int i = list2.size() - 1; i >= 0; i--) {
            if (list.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        print(list, list2);

    }

    private static void print(ArrayList list, ArrayList list2) {
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);
    }
}

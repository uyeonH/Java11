package collection;

import java.util.*;

public class HashMapEx1 {
    public static void main(String[] args) {

        HashMap map = new HashMap<>();
        map.put("AA", 100);
        map.put("BB", 100);
        map.put("CC", 80);
        map.put("DD", 90);

        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("e.getKey(), e.getValue() = " + e.getKey() +", "+ e.getValue());
        }

        set = map.keySet();
        System.out.println("set = " + set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;
        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }
        System.out.println("total = " + total);
        System.out.println(Collections.max(values));

    }
}

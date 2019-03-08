package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/11 下午8:28
 * @Description
 */

public class LinkedTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(10, 11);
        map.put(2, 2);
        map.put(4, 4);
        map.put(1, 1);

        for (Map.Entry entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        map.put(2, 11);
        map.put(10, 12);
        for (Map.Entry entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

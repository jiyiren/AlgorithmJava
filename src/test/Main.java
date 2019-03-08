package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/16 下午4:07
 * @Description
 */

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(10);
        map.put(1,2);
        map.put(2,3);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}

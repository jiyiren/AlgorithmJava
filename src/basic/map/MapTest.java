package basic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/1 下午1:00
 * @Description
 */

public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<>();
        map.put("张三",22);
        map.put("李四",25);
        map.put("王五",33);
        map.put("赵六",28);
        map.put("田七",25);
        map.put("李思",25);
        map.put("欣",25);

        Set<Map.Entry<String, Integer>> set=map.entrySet();

        for (Map.Entry<String, Integer> entry : set) {
            String name=entry.getKey();
            System.out.println(name);
//            System.out.println(name.contains("欣"));
            if(name.contains("七")){
                map.remove(name);
            }
        }
    }
}

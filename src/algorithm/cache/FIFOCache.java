package algorithm.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/27 下午9:30
 * @Description
 */

public class FIFOCache<K,V> extends LinkedHashMap<K,V>{

    private int size;

    public FIFOCache(int size){
        super(); //调用父类无参构造，不启用LRU规则
        this.size = size;
    }

    //重写淘汰机制
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size; //如果缓存存储达到最大值删除最后一个
    }

    public static void main(String[] args) {
        FIFOCache<Integer, Integer> map = new FIFOCache<Integer, Integer>(10);//设置容量为10
        for (int i = 0; i++ < 10;) {
            map.put(i, i);   //放入1-10总10个数据
        }
        System.out.println("起始存储情况："+map.toString());//打印起始存储情况

        map.put(8, 8);  //存入一个已存在的数据，也就是命中一次缓存中的数据
        System.out.println("命中一个已存在的数据："+map.toString());//打印命中之后的情况

        map.put(11, 11); //又存入缓存之外的数据
        System.out.println("新增一个数据后："+map.toString());//打印又存储一个数据之后的情况
    }
}

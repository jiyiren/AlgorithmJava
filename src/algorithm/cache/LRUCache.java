package algorithm.cache;

import java.util.LinkedHashMap;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/27 下午9:34
 * @Description
 */

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    int size;

    public LRUCache(int size) {
        //int initialCapacity, float loadFactor, boolean accessOrder这3个分别表示容量，加载因子和是否启用LRU规则
        super(size, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static void main(String[] args) {
//      FIFOCache<Integer, Integer> map = new FIFOCache<Integer, Integer>(10);//设置容量为10

        LRUCache<Integer, Integer> map = new LRUCache<Integer, Integer>(10);

        for (int i = 0; i++ < 10; ) {
            map.put(i, i);   //放入1-10总10个数据
        }
        System.out.println("起始存储情况：" + map.toString());//打印起始存储情况

        map.get(7);
        System.out.println("命中一个已存在的数据：" + map.toString());//打印命中之后的情况

        map.put(8, 8 + 1);  //存入一个已存在的数据，也就是命中一次缓存中的数据
        System.out.println("覆盖一个已存在的数据：" + map.toString());//打印命中之后的情况

        map.put(11, 11); //又存入缓存之外的数据
        System.out.println("新增一个数据后：" + map.toString());//打印又存储一个数据之后的情况
    }
}

package algorithm.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/16 下午4:49
 * @Description
 *
 * LRU: 是针对缓存满的时候的操作说明，即满了时再添加数据，则需要将最久没使用的数据删除掉，才可以再添加进数据；
 *
 * 利用 LinkedHashMap 实现 LRU 缓存，缓存 入参大小为 size，永远不变，
 *  LinkedHashMap 提供了一个构造函数(capacity, loadFactor, accessOrder), 提供是否设置 accessOrder 标记开启，开启表示自动实现 LRU
 *  但是 LinkedHashMap 还需要重写 removeEldestEntry() 方法返回是否删除当前 最老 数据，默认 false 不删除；
 *  而我们需要的是删除，因此需要修改。
 *
 *  然而，LinkedHashMap 有扩容机制，你设置了 LRU 外层缓存 size 大小，但是 LinkedHashMap 是不听这个指挥的，在数目达到 0.75 时就会括为原来的 2 倍大小；
 *  因此，我们无法拦截其扩容，但是可以限定 Map 内的数据最多有 size 个。这个就是通过删除最老元素来实现。
 *
 *  因此，我们只需要在当前数据插入后，判断 size() 是否高于 LRU 的 capacity，高于则删除最后一个就可以了。也就是说 Map 内部实际上最多可出现
 *  size + 1 个数据，多出的数据会被 removeEldestEntry() 立即删除，从而又变为 size 个。
 *
 */

public class LRU<K, V> {

    private LinkedHashMap<K,V> cache;

    public LRU(int capacity){
        cache = new LinkedHashMap<K, V>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key){
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value){
        cache.put(key, value);
    }

    public void clear(){
        cache.clear();
    }

    public void print(){
        for (Map.Entry entry : cache.entrySet()){
            System.out.println(entry.getValue() + "-");
        }
        System.out.println("==");
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put("1","1");
        lru.put("2","2");
        lru.put("3","3");
        lru.print();
        lru.get("1");
        lru.get("3");
        lru.put("4","4");
        lru.print();

        System.out.println();
        lru.clear();
        lru.put("1","1");
        lru.put("2","2");
        lru.put("3","3");
        lru.print();
        lru.get("1");
        lru.print();
        lru.put("4","4");
        lru.print();
    }
}

package algorithm.cache_simple;

import java.util.Map;
import java.util.Set;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/16 下午2:06
 * @Description
 *
 * 缓存管理操作接口，提供规定的缓存操作方法，主要基于 <key, value> 形式设计
 *
 *  1. 存数据(一个)；
 *  2. 取数据(一个或所有)；
 *  3. 是否过期；
 *  4. 是否包含；
 *  4. 清空(一个或所有)
 *
 */
public interface ICacheManager<T> {
    /**
     * add cache
     * @param key
     * @param cacheEntity
     */
    void putCache(String key, CacheEntity<T> cacheEntity);

    /**
     * add cache data
     * @param key
     * @param data
     */
    void putCacheData(String key, T data);
    /**
     * get cache entity
     * @param key
     * @return
     */
    CacheEntity<T> getCache(String key);

    /**
     * get the data in cache entity
     * @param key
     * @return
     */
    T getCacheData(String key);

    /**
     * get call cache entity
     * @return
     */
    Map<String, CacheEntity<T>> getAllCache();

    /**
     * get all keys
     * @return
     */
    Set<String> getAllKeys();

    /**
     * whether there is a cache entity
     * @param key
     * @return
     */
    boolean isContains(String key);

    /**
     * empty this cache by key
     * @param key
     */
    void clearByKey(String key);

    /**
     * empty all cache
     */
    void clearAll();

    /**
     * whether is time out
     * @param key
     * @param timeOutLength
     * @return
     */
    boolean isTimeOut(String key, long timeOutLength);

}

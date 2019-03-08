package algorithm.cache_simple;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/16 下午2:08
 * @Description
 */

public class CacheManagerImp<T> implements ICacheManager<T>, Serializable {

    private Map<String, CacheEntity<T>> caches = new ConcurrentHashMap<>();

    @Override
    public void putCache(String key, CacheEntity<T> cacheEntity) {
        caches.put(key, cacheEntity);
    }

    @Override
    public void putCacheData(String key, T data) {
        caches.put(key, new CacheEntity<T>(data, System.currentTimeMillis()));
    }

    @Override
    public CacheEntity<T> getCache(String key) {
        return isContains(key) ? caches.get(key) : null;
    }

    @Override
    public T getCacheData(String key) {
        return isContains(key) ? caches.get(key).getData() : null;
    }

    @Override
    public Map<String, CacheEntity<T>> getAllCache() {
        return caches;
    }

    @Override
    public Set<String> getAllKeys() {
        return caches.keySet();
    }

    @Override
    public boolean isContains(String key) {
        return caches.containsKey(key);
    }

    @Override
    public void clearByKey(String key) {
        if (isContains(key)){
            caches.remove(key);
        }
    }

    @Override
    public void clearAll() {
        caches.clear();
    }

    @Override
    public boolean isTimeOut(String key, long timeOutLength) {
        if (!isContains(key)){
            return true;
        }
        CacheEntity<T> cacheEntity = caches.get(key);
        if (timeOutLength <=0 || System.currentTimeMillis() - cacheEntity.getLastRefeshTime() >= timeOutLength){
            return true;
        }
        return false;
    }
}

package algorithm.cache_simple;

import java.io.Serializable;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/16 下午2:02
 * @Description
 *
 * 缓存存储实体类，使用泛型，这样缓存机制只需关注 CacheEntity 类，同时其他任意类型也可以存入进来
 *
 */

public class CacheEntity<T> implements Serializable {
    private T data;
    private long lastRefeshTime;

    public CacheEntity(){

    }

    public CacheEntity(T data, long lastRefeshTime) {
        this.data = data;
        this.lastRefeshTime = lastRefeshTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getLastRefeshTime() {
        return lastRefeshTime;
    }

    public void setLastRefeshTime(long lastRefeshTime) {
        this.lastRefeshTime = lastRefeshTime;
    }

}

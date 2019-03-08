package algorithm.cache_simple;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/16 下午2:32
 * @Description
 */

public class Main {
    public static void main(String[] args) {
        CacheManagerImp<String> cacheManagerImp = new CacheManagerImp<>();
        String key = "user01";
        cacheManagerImp.putCacheData(key, getDataFromUrl(key));
        if (cacheManagerImp.isTimeOut(key, 5 * 60 * 1000)) {
            cacheManagerImp.putCacheData(key, getDataFromUrl(key));
        }
        System.out.println("5 min 内缓存数据：" + cacheManagerImp.getCacheData(key));
    }

    public static String getDataFromUrl(String key) {
        return key + "_userInfo";
    }
}

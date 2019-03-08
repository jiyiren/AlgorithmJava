package basic.deepclone;

import java.util.Arrays;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/21 下午4:47
 * @Description
 */

public class Main {
    public static void main(String[] args) {
        TSMetric tsMetric = new TSMetric();
        tsMetric.setTimestamp(System.currentTimeMillis());
        tsMetric.setValue(12.0);
        tsMetric.setEndpoint("HH");
        tsMetric.setKeyName("KeyName");
        tsMetric.setMethod("Method");
        MetricGroupInfo m1 = new MetricGroupInfo("11");
        MetricGroupInfo m2 = new MetricGroupInfo("12");
        tsMetric.setMetricGroupInfos(Arrays.asList(m1,m2));

        TSMetric deepCopy = (TSMetric) tsMetric.clone();
        System.out.println(deepCopy.getMethod());

    }
}

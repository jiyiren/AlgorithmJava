package basic.deepclone;

import java.util.List;
import java.util.TreeMap;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/21 下午4:43
 * @Description
 */

public class TSMetric implements Cloneable{
    private String metric;                  // the name of metric
    private Long timestamp;                 // timestamp (second or millis)
    private Double value;                   // the value of metric ( only numerical type)
    private TreeMap<String, String> tags;   // the tags of metric

    private String endpoint;                // the name of host | for param to get data from api
    private String keyName;                 // key name for reduce by key | for judge data from api whether contains the metric

    private List<MetricGroupInfo> metricGroupInfos; // the metric group info

    private String method;                  // the aggregator method


    public TSMetric() {
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TreeMap<String, String> getTags() {
        return tags;
    }

    public void setTags(TreeMap<String, String> tags) {
        this.tags = tags;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<MetricGroupInfo> getMetricGroupInfos() {
        return metricGroupInfos;
    }

    public void setMetricGroupInfos(List<MetricGroupInfo> metricGroupInfos) {
        this.metricGroupInfos = metricGroupInfos;
    }

    // deep copy
    @Override
    public Object clone() {
        TSMetric o = null;
        try {
            o = (TSMetric) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (tags != null){
            o.tags = (TreeMap<String, String>) tags.clone();
        }

        return o;
    }

}

package designpattern.productandconsumer;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/26 上午9:47
 * @Description
 *
 * 产品
 *
 */

public class PCData {
    private final int data;
    public PCData(int data){
        this.data = data;
    }

    public PCData(String data){
        this.data = Integer.parseInt(data);
    }
    public int getData(){
        return data;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }
}

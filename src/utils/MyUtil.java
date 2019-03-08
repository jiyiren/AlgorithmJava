package utils;

import java.util.Random;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/21 下午10:40
 * @Description
 */

public class MyUtil {

    public static void main(String[] args) {
        int[] data  = getIntRandomArray(10,0,100);
        printIntArray("Before:",data);
        printIntArray("After:\n",data);
    }

    /**
     * 获取随机int数组
     * @param count 数组个数
     * @param min   最小值
     * @param max   最大值
     * @return
     */
    public static int[] getIntRandomArray(int count, int min, int max){
        int[] data = new int[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            data[i] = random.nextInt(max-min)+min;
        }
        return data;
    }

    /**
     * 随机一个int数据
     * @param min 范围最小值
     * @param max 范围最大值
     * @return
     */
    public static int getRandomInt(int min, int max){
        Random random = new Random();
        return (random.nextInt()%max)+min;
    }

    /**
     * 输入带有提示的数组
     * @param tips 提示
     * @param data 数组
     */
    public static void printIntArray(String tips,int[] data){
        StringBuilder stringBuilder = new StringBuilder(tips);
        stringBuilder.append("[");
        for(int i=0; i<data.length; i++){
            stringBuilder.append(data[i]+",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }


}

package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/14 上午11:38
 * @Description
 *
 * 面试题11：旋转数组中最小的数
 */

public class J11_MinmumLoopArray {

    /**
     * 1. 如果为1，2，3，4这样的递增序列，则直接返回第一个
     * 2. 如果为3，4，5，1，2二个递增序列，则利用二分查找
     * 3. 如果出现 1，1，0，1，1，1，1 这种有很多相同值的，则只能进行顺序查找
     * @param data
     * @return
     */
    public static int minmumLoopArray(int[] data){
        int left = 0;
        int right = data.length-1;
        // 递增序列，直接返回第一个
        if(data[left]<data[right]){
            return data[left];
        }

        int middle = 0;
        while (right-left>1){
            middle = (right+left)/2;
            // 具有同值的，进行顺序查找
            if(data[left]==data[right] && data[middle]==data[left]){
                return minInOrder(data,left,right);
            }
            // 进行二分查找
            if(data[middle]>=data[left]){
                left = middle;
            }else if (data[middle]<=data[right]){
                right = middle;
            }
        }

        return data[right];
    }

    /**
     * 以顺序方式查找最小值
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int minInOrder(int[] data,int left,int right){
        int min = data[left];
        for (int i=left;i<=right;i++){
            if(min>data[i]){
                min = data[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        int[] data={3,4,5,1,2};
//        int[] data={1,2,3,4,5};
        int[] data={1,0,1,1,1};
        System.out.println(minmumLoopArray(data));
    }
}

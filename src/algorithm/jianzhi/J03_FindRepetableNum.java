package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/13 上午10:00
 * @Description
 */

public class J03_FindRepetableNum {
    public static void main(String[] args) {
        int[] data = {3,1,2,0,2,5,3}; // n+1维度数组存0-n个数字，求重复的
//        System.out.println(findRepeatableNum(data));
        System.out.println(findRepeatableNum(data,0));

        int[] mdata = {4,2,3,1,3,6,7}; //n+1维度数组存1-n个数字，求重复的那个
//        System.out.println(findRepeatableNumTwo(mdata));
        System.out.println(findRepeatableNum(mdata,1));

        int[] mmdata = {2,3,5,4,3,2,6,7};
        System.out.println(findRepeatableNumCanNotModify(mmdata,1,7));
    }

    /**
     * 通用的方法
     * @param data   原数组
     * @param minNum 所存连续数据的最小值
     * @return
     */
    public static int findRepeatableNum(int[] data,int minNum){
        int temp;
        for (int i=0;i<data.length;i++) {
            // 数据是连续的，下标从0开始，所以需要为下标+最小值就可以相互对应
            // 因此，遇到比下标变量转值则 +minNum,遇到数值转下标则 -minNum
            while (data[i] != i+minNum) { //小标变量兑换为值
                if (data[i] == data[data[i]-minNum]) {//数值兑换为下标
                    return data[i];
                } else {
                    temp = data[i];
                    data[i] = data[temp-minNum];//数值兑换为下标
                    data[temp-minNum] = temp; //数值兑换为下标
                }
            }
        }
        return -1;
    }

    /**
     * Interval为1的时候
     * @param data
     * @return
     */
    public static int findRepeatableNumTwo(int[] data){
        int j,temp;
        for (int i=0;i<data.length;i++) {
            j = i+1;
            while (data[i] != j) {
                if (data[i] == data[data[i]-1]) {
                    return data[i];
                } else {
                    temp = data[i];
                    data[i] = data[temp-1];
                    data[temp-1] = temp;
                }
            }
        }
        return -1;
    }

    /**
     * 不修改数组实现查找n+1数组中包含1-n个数字的重复数字：
     * 法1：用n-1+1 个辅助空间，遍历n+1个数组，有则放到数组里，如果辅助空间里有值则就是重复的数字
     * 法2：对1-n个数字分采用二分查找方式，计算前后两段数字的个数，如果数字个数超过当前段内数字个数，那么重复的一定在该段
     * 法2缺点无法查找多个重复的
     *
     * 法2实现：以时间换空间，时间复杂度O(nlogn),空间复杂度O(1), 二分查找为O(logn),内部countRange为O(n)==》O(nlogn)
     *
     * @param data
     * @return
     */
    public static int findRepeatableNumCanNotModify(int[] data,int minNum,int maxNum){
        if(minNum>maxNum){
            return -1;
        }
        int start = minNum;
        int end = maxNum;
        // 二分查找
        while (start < end){
            int middle = (start+end)/2;
            if(countRange(data,start,middle) > middle-start+1){
                end = middle;
            }else if(countRange(data,middle+1,end)>end-middle){
                start = middle+1;
            }else {
                return -1;
            }
        }

        return start;
    }

    // 计算[minNum,maxNum]在数组中出现的个数
    // 时间复杂度O(n)
    public static int countRange(int[] data,int minNum,int maxNum){
        int count=0;
        for(int j=0;j<data.length;j++){
            if(data[j]>=minNum && data[j]<=maxNum){
                count++;
            }
        }
        return count;
    }


}

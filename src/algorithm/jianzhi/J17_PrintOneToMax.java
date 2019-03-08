package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/16 下午10:50
 * @Description
 * 面试题17：打印从1到最大的n位数
 *
 * Tip: 需要考虑大数问题
 */

public class J17_PrintOneToMax {


    public static void printOneToMax(int n){
        char[] bits = new char[n];
        printRecursive(bits,n,0);

    }

    /**
     * 递归设置数组各个位置上的值，知道最后一步打印当前数组设置的值
     * @param bits
     * @param n
     * @param index
     */
    public static void printRecursive(char[] bits,int n,int index){
        if(index >= n){
//            System.out.println(bits);
            printNumber(bits);
            return;
        }
        for (int i=0;i<10;i++){
            bits[index] = (char)(i+'0');
            printRecursive(bits,n,index+1);
        }
    }

    /**
     * 字符数组前面为0的则不打印
     * @param bits
     */
    public static void printNumber(char[] bits){
        int i = 0;
        for (i=0;i<bits.length;i++){
            if(bits[i]!='0'){
                break;
            }
        }
        System.out.println(new String(bits,i,bits.length-i));
    }

    public static void main(String[] args) {
        printOneToMax(5);
    }
}

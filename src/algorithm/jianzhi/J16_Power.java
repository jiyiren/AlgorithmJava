package algorithm.jianzhi;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/14 下午10:49
 * @Description
 * 面试题16：数值的整数次方，不需要考虑大数问题
 */

public class J16_Power {

    public static double myPower(double base , int exp){

        if(base==0){
            return 0;
        }
        if(exp==0){
            return 1;
        }else if(exp>0){
            return myPowerUnsigned(base,exp);
        }else {
            return 1.0/myPowerUnsigned(base,-exp);
        }
    }

    /**
     * 相比连乘效率更高的指数计算，2^5 = 2^2 * 2^2 * 2
     * @param base
     * @param exp
     * @return
     */
    public static double myPowerUnsigned(double base, int exp){
        if(exp==0){
            return 1;
        }
        if(exp == 1){
            return base;
        }

        double result = myPowerUnsigned(base,exp >>1);
        result *= result;
        if((exp&0x1) == 1){
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(myPower(2,3));
        System.out.println(myPower(2,4));
        System.out.println(myPower(2,-4));
        System.out.println(myPower(2,-3));
    }
}

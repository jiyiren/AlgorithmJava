package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/1 下午8:12
 * @Description
 * 给定一个范围为 32 位 int 的整数，将其颠倒。

    例 1:

    输入: 123
    输出:  321


    例 2:

    输入: -123
    输出: -321


    例 3:

    输入: 120
    输出: 21


    注意:

    假设我们的环境只能处理 32 位 int 范围内的整数。根据这个假设，如果颠倒后的结果超过这个范围，则返回 0。
 */

public class L7_ReverInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

    public static int reverse(int x) {

        if(x==0||x==0x80000000){
            return 0;
        }
        int flag = 1;
        int target = Math.abs(x);
        if(x<0){
            flag = -1;
        }
        int remain = 0;
        if(target>0x3fffffff){
            int max = 0x7fffffff;
            int[] bits = new int[31];
            int i=0;
            while(max>0){
                bits[i++] = max%10;
                max /= 10;
            }
            i--;
            int mtarget = target;
            while (mtarget>0){
                remain = mtarget%10;
                if(remain > bits[i]){
                    return 0;
                }else if(remain<bits[i]){
                    break;
                }
                mtarget /= 10;
                i--;
            }
        }

        int result = 0;
        while (target>0){
            remain = target%10;
            target /= 10;
            result = result*10+remain;
        }
        return flag*result;
    }
}

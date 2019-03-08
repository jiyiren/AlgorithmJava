package problem.nowcoder;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/24 下午2:39
 * @Description
 */

public class HeightTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();   //结点数目
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i]=-1;
            }
            //n-1行
            for(int i = 1;i<=n-1;i++){
                int value = sc.nextInt();
                int key = sc.nextInt();
                nums[key]=value;
            }
            System.out.println(getHeight(n,nums));

        }
//        int n = 5;
//        int[] nums = new int[5];
//        nums[0]=-1;
//
//        nums[1] = 0;
//        nums[2] = 0;
//        nums[3] = 1;
//        nums[4] = 1;
//        System.out.println(getHeight(n,nums));

    }
    public static int getHeight(int n,int[] nums){
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                height[i]=-1;
            }else {
                height[i]=1;
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int curHe = getSingleHeight(i,nums,height);
            if(curHe>max){
                max = curHe;
            }
        }
        return max;
    }

    public static int getSingleHeight(int index,int[] nums,int[] height){
        if(height[index]>0){
            return height[index];
        }
        height[index] =  1+ getSingleHeight(nums[index],nums,height);
        return height[index];
    }
}

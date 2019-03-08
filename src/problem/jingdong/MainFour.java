package problem.jingdong;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/9 下午6:38
 * @Description
 */

public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(count(s));
        }
    }

    public static int count(String s){
        int[] count = new int[s.length()+1];
        count[0]=0;
        count[1]=1;

        for(int i=1;i<s.length();i++){
            int m=0,n=i;
            int flag = 0;
            while(m<n){
                if(s.charAt(m++)!=s.charAt(n--)){
                    flag=1;//非回文
                    break;
                }
            }
            if(flag==1){
                count[i+1] = count[i]*2;
            }else{
                count[i+1] = count[i]*2+1;
            }
        }

        return count[s.length()];
    }
}

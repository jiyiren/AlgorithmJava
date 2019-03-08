package problem.microsoft;

import java.util.Scanner;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/2 下午6:56
 * @Description
 */

public class MainFour {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int count = sc.nextInt();
            for (int i=0;i<count;i++){
                int n = sc.nextInt();
                int m = sc.nextInt();
                String[] data = new String[n];
                for(int j=0;j<n;j++){
                    data[j]=sc.nextLine();
                }

//                System.out.println(edgeCount(n));
            }
        }
    }

    public static String canAchieve(int n,int m,String[] data){

        int startIndex=0;
        int end = 0;
        int flag = 0;
        for(int i=0;i<n;i++){
            if(flag == 0 && data[i].contains("s")){
                flag = 1;
                startIndex = data[i].indexOf('s');
                end = data[i].indexOf('x',startIndex);
                if(end<0){
                    end = data[i].length();
                }
            }else{
                for (int k=startIndex;k<end;k++){

                }
            }
        }
        return "NO";
    }
}

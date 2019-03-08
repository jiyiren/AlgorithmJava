package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/3/25 下午10:49
 * @Description
 */

public class L6_ConvertStrFormat {
    public static void main(String[] args) {
        System.out.println(convert("ABCDE",3));
    }

    public static String convert(String s, int numRows) {
        if(numRows<=1 || s.length()<numRows){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int rowOdd;
        if(numRows%2 == 0){
            rowOdd = (numRows/2)*3;
        }else{
            rowOdd = (numRows/2)*2+(numRows-(numRows/2));
        }
        int[] row = new int[s.length()];
        int rowPoint = 0;

        for(int i=0;i<numRows;i++){
            int j;
            int flag = 0;
            if(i%2==0){
                rowPoint=0;
                j=i;
            }else{
                j = row[flag]+1;
                flag ++;
            }
            while(j<s.length()){
                sb.append(s.charAt(j));
                if(i%2==0){//odd
                    row[rowPoint]=j;
                    rowPoint +=2;
                    j += rowOdd;
                }else{
                    if(flag%2==0){
                        if(flag<=(rowPoint-2)){
                            j = row[flag]+1;
                        }else {
                            break;
                        }
                    }else{
                        j = row[flag-1]+1+numRows-i+i/2;
                    }
                    flag++;
                }

            }
        }
        return sb.toString();
    }
}

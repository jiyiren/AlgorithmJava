package problem.jingdong;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/9 下午6:38
 * @Description
 */

public class MainTwo {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            long t = sc.nextInt();
//            for(long i=0;i<t;i++){
//                long n = sc.nextInt();
//                System.out.println(out(n));
//            }
//        }

        long n = (long) Math.pow(2,63)-3;
        long m = 5;
        System.out.println(n);
//        System.out.println(Math.sqrt(100));
        System.out.println(out(n));

    }

    public static String out(long n){
        long x = n;
        long count = 0;
        while(n%2==0){
            n = n/2;
            count++;
        }
        if(count==0||n==0){
            return "No";
        }
        return ""+n+" "+(x/n);
    }
}

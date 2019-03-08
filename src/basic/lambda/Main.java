package basic.lambda;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/5 下午11:04
 * @Description
 */

public class Main {
    public static void main(String[] args) {
//        lambda01(1);
        lambda09(1);
    }

    /**
     * 1. 替代匿名内部类
     */
    public static void lambda01(int flag) {
        if (flag <= 0) {
            //普通
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello");
                }
            }).start();
        } else {
            //lambda
            new Thread(() -> System.out.println("Hello")).start();
        }
    }

    /**
     * 2. 集合迭代
     *
     * @param flag
     */
    public static void lambda02(int flag) {
        List<String> language = Arrays.asList("java", "scala", "python");
        if (flag <= 0) {
            //普通
            for (String one :
                    language) {
                System.out.print(one + " ");
            }
        } else {
            //lambda
            language.forEach(x -> System.out.print(x + " "));
            //或者 下面这是对参数不修改的情况使用，若要修改需用上面的
            language.forEach(System.out::println);
        }
    }

    /**
     * 3. 用lambda表达式实现map
     *
     * @param flag
     */
    public static void lambda03(int flag) {
        List<Double> data = Arrays.asList(10.0, 20.0, 30.0);
        if (flag <= 0) {
            //普通

        } else {
            //lambda
            data.stream().map(x -> x + x * 0.5).forEach(x -> System.out.println(x));
        }
    }

    /**
     * 4. 用lambda表达式实现map与reduce
     * > map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个
     *
     * @param flag
     */
    public static void lambda04(int flag) {
        List<Double> data = Arrays.asList(10.0, 20.0, 30.0);
        if (flag <= 0) {
            //普通
            double sum = 0;
            for (double each : data) {
                each += each * 0.05;
                sum += each;
            }
            System.out.println(sum);
        } else {
            //lambda
            Double result = data.stream().map(x -> x + x * 0.5).reduce((sum, y) -> sum + y).get();
            System.out.println(result);
        }
    }


    /**
     * 5.filter操作,过滤操作
     *
     * @param flag
     */
    public static void lambda05(int flag) {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        if (flag <= 0) {

        } else {
            List<Double> filteredCost = cost.stream().filter(x -> x > 14).collect(Collectors.toList());
            filteredCost.forEach(x -> System.out.println(x));
        }
    }


    /**
     * 6. 与函数式接口Predicate配合
     * <p>
     * 除了在语言层面支持函数式编程风格，Java 8也添加了一个包，
     * 叫做 java.util.function。它包含了很多类，用来支持Java的函数式编程。
     * 其中一个便是Predicate，使用 java.util.function.Predicate 函数式接口以及lambda表达式，
     * 可以向API方法添加逻辑，用更少的代码支持更多的动态行为。Predicate接口非常适用于做过滤。
     *
     * @param flag
     */
    public static void lambda06(int flag) {
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        if (flag <= 0) {

        } else {
            //lambda
            System.out.println("Language starts with J: ");
            filterTest(languages, x -> x.startsWith("J"));
            System.out.println("\nLanguage ends with a: ");
            filterTest(languages, x -> x.endsWith("a"));
            System.out.println("\nAll languages: ");
            filterTest(languages, x -> true);
            System.out.println("\nNo languages: ");
            filterTest(languages, x -> false);
            System.out.println("\nLanguage length bigger three: ");
            filterTest(languages, x -> x.length() > 3);
        }
    }

    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x));
    }

    /**
     * 例子1 对列表的每个元素应用函数
     *
     * @param flag
     */
    public static void lambda07(int flag) {
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        if (flag <= 0) {

        } else {
            //lamba
            String G7Conntries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
            System.out.println(G7Conntries);
        }
    }

    /**
     * 例子2 对集合去重 distinct()
     *
     * @param flag
     */
    public static void lambda08(int flag) {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        if (flag <= 0) {

        } else {
            List<Integer> mlist = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
            System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, mlist);
        }
    }

    /**
     * 例子3 计算集合元素的最大值、最小值、总和以及平均值
     * <p>
     * ntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。
     * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，
     * 描述流中元素的各种摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。
     * 它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。
     *
     * @param flag
     */
    public static void lambda09(int flag) {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        if (flag <= 0) {

        } else {
            IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
            System.out.println("Highest prime number in List : " + stats.getMax());
            System.out.println("Lowest prime number in List : " + stats.getMin());
            System.out.println("Sum of all prime numbers : " + stats.getSum());
            System.out.println("Average of all prime numbers : " + stats.getAverage());
        }
    }
}

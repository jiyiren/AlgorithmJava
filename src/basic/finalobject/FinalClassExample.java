package basic.finalobject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/27 上午10:14
 * @Description
 *
 * http://www.importnew.com/7535.html
 * 如何写一个不可变类?
 * 不可变的对象指的是一旦创建之后，它的状态就不能改变,
 * ①不可变对象对于缓存是非常好的选择，因为你不需要担心它的值会被更改。
 * ②不可变类的另外一个好处是它自身是线程安全的，你不需要考虑多线程环境下的线程安全问题。
 *
 * 要创建不可变类，要实现下面几个步骤：
    1.将类声明为final，所以它不能被继承
    2.将所有的成员声明为私有的，这样就不允许直接访问这些成员
    3.对变量不要提供setter方法
    4.将所有可变的成员声明为final，这样只能对它们赋值一次
    5.通过构造器初始化所有成员，进行深拷贝(deep copy)
    6.在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝
 *
 *
 * 自己理解：不可变类就是类的内部状态不可变，也就是说外部对内部没有能改变的权利；
 * 而改变都是基于属性的，属性分为两类，
 * 1.基本属性，基于复制的，用private final即可
 * 2.对象属性，则在getter时不能暴露其地址，因此不仅要private final 还要进行深复制
 *
 */

public class FinalClassExample {

    private final int id;

    private final String name;

    private final HashMap testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * 可变对象的访问方法
     */
    public HashMap getTestMap() {
        //return testMap;
        return (HashMap) testMap.clone();
    }

    /**
     * 实现深拷贝(deep copy)的构造器
     * @param i
     * @param n
     * @param hm
     */

    public FinalClassExample(int i, String n, HashMap hm){
        System.out.println("Performing Deep Copy for Object initialization");
        this.id=i;
        this.name=n;
        HashMap tempMap=new HashMap();
        String key;
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            key= (String) it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap=tempMap;
    }

    /**
     * 实现浅拷贝(shallow copy)的构造器
     * @param i
     * @param n
     * @param hm
     */
    /**
     public FinalClassExample(int i, String n, HashMap hm){
     System.out.println("Performing Shallow Copy for Object initialization");
     this.id=i;
     this.name=n;
     this.testMap=hm;
     }
     */

    /**
     * 测试浅拷贝的结果
     * 为了创建不可变类，要使用深拷贝
     * @param args
     */
    public static void main(String[] args) {
        HashMap h1 = new HashMap();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i=10;

        FinalClassExample ce = new FinalClassExample(i,s,h1);

        //Lets see whether its copy by field or reference
        System.out.println(s==ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:"+ce.getId());
        System.out.println("ce name:"+ce.getName());
        System.out.println("ce testMap:"+ce.getTestMap());
        //change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:"+ce.getId());
        System.out.println("ce name after local variable change:"+ce.getName());
        System.out.println("ce testMap after local variable change:"+ce.getTestMap());

        HashMap hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());

    }
}

package test;

import java.util.ArrayList;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/21 上午10:22
 * @Description
 */

public class ArrayTest {

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        for (int i=0;i<9;i++){
            data.add(i);
        }
        data.add(10);
        data.add(11);

    }
}

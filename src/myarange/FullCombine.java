package myarange;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/18 下午2:01
 * @Description ##
 * 1. 求数组的全组合数：不包含空 ===》组合
 * 如：abc => a, b, c, ab, ac, bc, abc
 * 2. 求数组的元素所有子集：包含空集 ===》子集
 * 如：abc => {},{a},{b},{c},{ab},{ac},{bc},{abc}
 */

public class FullCombine {
    static char[] data = {'A', 'B', 'C'};
    static int length = data.length;
    static List<List<Character>> result = new ArrayList<>();


    public static void main(String[] args) {
        SubSets();
    }

    public static void SubSets() {
        SingleSubSet(0, new LinkedList<Character>());
        for (List<Character> one : result) {
            System.out.println(one);
        }
    }

    public static void SingleSubSet(int startIndex, List<Character> tempList) {
        // 这里包函了空集，若要不包含，则这里加个空判断，是空则不加入 result
        result.add(new ArrayList<>(tempList));
        for (int i = startIndex; i < length; i++) {
            tempList.add(data[i]);
            SingleSubSet(i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }


}

package algorithm.dfsbdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/31 下午7:40
 * @Description
 */

public class SubSets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);                             // 排序是为了输出的结果有序，这样给平台编辑器好对比
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {9, 4, 1};
        int[] nums = {1, 3, 2};
        List<List<Integer>> result = subsets(nums);
//        List<List<Integer>> result = mySubsets(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<List<Integer>> mySubsets(int[] data) {
        List<List<Integer>> list = new ArrayList<>();
        myBackTrack(list, new ArrayList<>(), data, 0, data.length - 1);
        return list;
    }

    public static void myBackTrack(List<List<Integer>> list, List<Integer> tempList, int[] data, int startIndex, int endIndex) {
        list.add(new ArrayList<>(tempList));
        for (int i = startIndex; i <= endIndex; i++) {
            tempList.add(data[i]);
            myBackTrack(list, tempList, data, startIndex + 1, endIndex);
            tempList.remove(tempList.size() - 1);
        }
    }
}

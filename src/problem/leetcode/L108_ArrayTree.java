package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/8 下午7:06
 * @Description
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

    此题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。

    示例:

    给定有序数组: [-10,-3,0,5,9],

    一种可行答案是：[0,-3,9,-10,null,5]，它可以表示成下面这个高度平衡二叉搜索树：

       0
      / \
    -3   9
    /   /
  -10  5
 *
 */

public class L108_ArrayTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0,nums.length-1,nums);
    }

    public TreeNode buildTree(int left,int right,int[] nums){
        if(left>right){
            return null;
        }
        int middle = (left+right)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildTree(left,middle-1,nums);
        root.right = buildTree(middle+1,right,nums);
        return root;
    }
}

package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/8 下午6:07
 * @Description
 *
 * 给定一棵树的中序遍历与后序遍历，依据此构造二叉树
 * 注意:
    你可以假设树中没有重复的元素。

    例如，给出

    中序遍历 = [9,3,15,20,7]
    后序遍历 = [9,15,7,20,3]
    返回如下的二叉树：

      3
     / \
    9  20
      /  \
     15   7
 */

public class L106_InPostConsTree {
    public static void main(String[] args) {
        L106_InPostConsTree inPostConsTree = new L106_InPostConsTree();
        int[] inorder ={9,3,15,20,7};
        int[] postorder= {9,15,7,20,3};
        TreeNode root= inPostConsTree.buildTree(inorder,postorder);
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
            return null;
        }
        return buildT(0,inorder.length-1,postorder.length-1,inorder,postorder);
    }

    /**
     * 采取和已知 前序和中序一样的方式
     * @param left
     * @param right
     * @param target
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildT(int left,int right,int target,int[] inorder, int[] postorder){
        if(target < 0 || left>right){
            return null;
        }
        TreeNode root = new TreeNode(postorder[target]);
        int middle = right;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                middle = i;
                break;
            }
        }
        // target为从后向前的， middle-right一定为负数的，middle-right为右分枝的点个数，
        root.left = buildT(left,middle-1,target+middle-right-1,inorder,postorder);
        root.right = buildT(middle+1,right,target-1,inorder,postorder);
        return root;
    }

}

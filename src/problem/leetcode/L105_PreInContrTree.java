package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/8 下午4:09
 * @Description
 *
 *
 * 给定一棵树的前序遍历与中序遍历，依据此构造二叉树。

    注意:
    你可以假设树中没有重复的元素。

    例如，给出

    前序遍历 = [3,9,20,15,7]
    中序遍历 = [9,3,15,20,7]
    返回如下的二叉树：

         3
        / \
       9  20
         /  \
        15   7
 *
 */

public class L105_PreInContrTree {

    public static void main(String[] args) {
        L105_PreInContrTree preInContrTree = new L105_PreInContrTree();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode root= preInContrTree.buildTree(pre,in);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        return buildT(0,inorder.length-1,0,preorder,inorder);
    }


    //left,right 为inorder的开始下标和结束下标，target为preorder的下标，递归逐个比较preorder值，因为preorder是根结点在前
    public TreeNode buildT(int left,int right,int target,int[] preorder, int[] inorder){
        if(target >= preorder.length ||left>right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[target]);
        int middle = 0;//middle为当前前序结点在inorder中的位置，一定可找到
        for(int i=left;i<=right;i++){
            if(inorder[i]==preorder[target]){
                middle = i;
                break;
            }
        }
        node.left=buildT(left,middle-1,target+1,preorder,inorder);//因为前序遍历下面比较的总是左结点在前
        //target+middle-left+1跨越左分枝的结点，找右分枝点，因此一定可找到
        node.right=buildT(middle+1,right,target+middle-left+1,preorder,inorder);
        return node;
    }


}

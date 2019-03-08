package problem.leetcode;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/8 下午5:01
 * @Description
 */

public class TreeTest {
    public static void main(String[] args) {
        TreeTest treeTest =new TreeTest();
        TreeNode root= treeTest.buildTree();
        if(root!=null){
            System.out.println(root.val);
        }else {
            System.out.println("null");
        }

    }

    public TreeNode buildTree(){
        TreeNode root = null;
//        buildT(root);
        root = buildT();
        return root;
    }

    public void buildT(TreeNode root){
        if(root==null){
            root = new TreeNode(4);
        }
    }

    public TreeNode buildT(){
        TreeNode root = new TreeNode(4);
        return root;
    }
}

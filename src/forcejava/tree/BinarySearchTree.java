package forcejava.tree;


/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/2 下午9:28
 * @Description
 */

public class BinarySearchTree<T extends Comparable<T>> {

    Node root = null;

    public boolean insert(T data){
        if (root == null){
            root = new Node(data);
            return true;
        }

        Node tmp = root;
        while (tmp != null){
            if (data.compareTo((T) tmp.data) < 0){
                if (tmp.left == null){
                    tmp.left = new Node(data);
                }else{
                    tmp = tmp.left;
                    break;
                }
            }else{
                if (tmp.right == null){
                    tmp.right = new Node(data);
                }else{
                    tmp = tmp.right;
                    break;
                }
            }
        }
        return true;
    }
}

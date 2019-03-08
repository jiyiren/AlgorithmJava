package forcejava.tree;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/8/2 下午2:44
 * @Description
 */

public class Node<T extends Comparable<T>> {
    Node left;
    Node right;
    T data;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }
}

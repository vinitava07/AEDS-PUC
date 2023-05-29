
public class TNode {

    TNode left;
    TNode right;
    int x;
    BinaryTree BT;

    TNode() {
        this.left = null;
        this.right = null;
        this.x = 0;
        this.BT = null;
    }

    TNode(int num) {
        this.left = null;
        this.right = null;
        this.x = num;
        this.BT = new BinaryTree();

    }

}

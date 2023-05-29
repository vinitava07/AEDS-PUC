public class NodeMatrix {

    NodeMatrix up;
    NodeMatrix down;
    NodeMatrix left;
    NodeMatrix right;
    int data;

    NodeMatrix() {
        this.up = null;
        this.down = null;
        this.left = null;
        this.right = null;
        this.data = 0;
        

    }
    NodeMatrix(int x) {
        this.up = null;
        this.down = null;
        this.left = null;
        this.right = null;
        this.data = x;

    }
}

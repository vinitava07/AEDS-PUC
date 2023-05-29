public class AVLNode {

    Personagem p;
    int h;
    AVLNode left;
    AVLNode right;
    public AVLNode() {
        this.left = null;
        this.right = null;
        this.p = null;
        this.h = 0;
    }
    public AVLNode(Personagem pe) {
        this.left = null;
        this.right = null;
        this.p = pe.clone();
        this.h = 0;
    }

    
}

public class RBNode {

    public RBNode left;
    public RBNode right;
    public RBNode parent;
    public Personagem p;
    public boolean color;

    public RBNode() {
        this.p = null;
        this.left = null;
        this.right = null;
        this.color = false;
        this.parent = null;

    }

    public RBNode(Personagem pe) {
        this(pe, null, null);
    }

    public RBNode(Personagem pe, RBNode lt, RBNode rt) {

        this.p = pe.clone();
        this.left = lt;
        this.right = rt;
        this.color = false;

    }

}

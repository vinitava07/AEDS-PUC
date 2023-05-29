public class Node {

    Node left;
    Node right;
    public Personagem p;
    public String nome;

    Node() {
        this.left = null;
        this.right = null;
        this.p = null;
    }
    public Node(Personagem pe) {
        this.left = null;
        this.right = null;
        this.p = pe.clone();

    }


    
}

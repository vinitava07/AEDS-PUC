public class Node {

    public Personagem p;
    public Node next;
    public Node prev;


    Node() {
        this.p = new Personagem();
        this.next = null;
        this.prev = null;

    }
    Node(Personagem personagem) {
        this.p = personagem.clone();
        this.next = null;
        this.prev = null;

    }

    
}

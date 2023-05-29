public class BinaryTree {

    Node root;
    public boolean possui = false;

    BinaryTree() {
        this.root = null;
    }

    public Node insert(Node i, Personagem pe) {

        if (this.root == null) {
            this.root = new Node(pe);
        } else if (i == null) {
            i = new Node(pe);
        } else if (pe.getNome().compareTo(i.nome) < 0) {

            i.left = insert(i.left, pe);

        } else if (pe.getNome().compareTo(i.nome) > 0) {
            i.right = insert(i.right, pe);

        }
        return i;
    }

    public boolean search(Node i, String s) {
        boolean r = false;
        boolean t;
        if (i != null) {
           
            r = i.nome.equals(s) || search(i.left, s) || search(i.right, s);
            if (i.nome.equals(s)) {
                return r;
            }
            System.out.print("ESQ ");
            System.out.print("DIR ");

        }

        return r;
    }

    public void printTree(Node i) {
        if (i != null) {
            System.out.println(i.nome);
            printTree(i.left);
            printTree(i.right);
        }
    }

}

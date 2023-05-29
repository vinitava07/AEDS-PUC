class Node {

    Node left;
    Node right;
    public int fb;
    public int hr = 0;
    public int hl = 0;
    public Personagem p;

    Node() {
        this.left = null;
        this.right = null;
        this.p = null;
        this.fb = 0;
        hr = 0;
        hl = 0;
    }

    public Node(Personagem pe) {
        this.left = null;
        this.right = null;
        this.p = pe.clone();
        this.fb = 0;
        hr = 0;
        hl = 0;
    }

}

public class AVLTreeMeu {

    Node root;
    int height;
    boolean possui;
    public boolean att;

    public AVLTreeMeu() {

        this.root = null;
        this.height = 0;
        this.possui = false;
        this.att = false;

    }

    public void insert(Personagem p) {

        this.root = insert(this.root, p);
        // if (this.root.left == null) {
        // this.root.fb += 1;

        // } else if (this.root.right == null) {
        // this.root.fb -= 1;
        // }
        this.att = false;
        if (p.getNome().compareTo(this.root.p.getNome()) < 0) {

            balanceLeft(this.root);
        }
        if (p.getNome().compareTo(this.root.p.getNome()) > 0) {

            balanceRight(this.root);
        }

    }

    public boolean search(Node i, String s) {
        boolean r = false;
        if (i != null && !(i.p.getNome().equals(s))) {
            System.out.print("esq ");
            search(i.left, s);
            System.out.print("dir ");
            search(i.right, s);

        }
        return r;
    }

    public Node insert(Node i, Personagem p) {
        boolean t = false;

        if (i == null) {
            i = new Node(p);

        } else if (p.getNome().compareTo(i.p.getNome()) < 0) {
            if (i.right == null && i.left == null && i != this.root) {
                this.att = true;
            }
            i.left = insert(i.left, p);
            if (this.att) {
                i.fb -= 1;
            }
            // if (i.right != null) {
            // i.fb = i.right.fb - i.left.fb;
            // }
        } else if (p.getNome().compareTo(i.p.getNome()) > 0) {
            if (i.right == null && i.left == null && i != this.root) {
                this.att = true;
            }
            i.right = insert(i.right, p);
            if (this.att) {
                i.fb += 1;
            }
            // if (i.left != null) {
            // i.fb = i.right.fb - i.left.fb;
            // }
            // if (i.left == null) {
            // i.fb = i.right.fb - 0;
            // } else {
            // i.fb = i.right.fb - i.left.fb;
            // }
        }
        return i;
    }

    public void balanceLeft(Node i) {

        // if (i.fb ) {

        // }

    }

    public void balanceRight(Node i) {

    }

    public int sizeTree(Node i) {
        int aux = 0;
        if (i != null) {
            System.out.print(i.p.getNome());
            if(i.left == null && i.right == null) {
                System.out.print("0");
            }
            else if (i.left == null) {
                System.out.print(" " + (i.right.fb - 0));

            } else if (i.right == null) {
                System.out.print(" " + (0 - i.left.fb));
            } else {
                System.out.print(" " + (i.right.fb - i.left.fb));

            }
            if (i.left != null) {

                System.out.print(" esq: " + i.left.p.getNome());
                System.out.print(" " + i.left.fb);

            } else {
                System.out.print(" esq: null ");
            }
            if (i.right != null) {

                System.out.print(" dir: " + i.right.p.getNome());
                System.out.print(" " + i.right.fb);

            } else {
                System.out.print(" dir: null ");
            }
            System.out.println();
            sizeTree(i.left);
            sizeTree(i.right);
        }
        return aux;
    }

}

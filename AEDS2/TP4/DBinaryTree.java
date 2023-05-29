public class DBinaryTree {

    TNode root;
    public boolean possui = false;

    DBinaryTree() {
        this.root = null;
    }

    public TNode insert(TNode i, int x) {

        if (this.root == null) {
            this.root = new TNode(x);
        } else if (i == null) {
            i = new TNode(x);
        } else if (x < i.x) {

            i.left = insert(i.left, x);

        } else if (x > i.x) {
            i.right = insert(i.right, x);

        }
        return i;
    }

    public boolean search(TNode i, String s) {
        boolean r = false;
        if (i != null && !this.possui) {

            r = i.BT.search(i.BT.root, s);
            if (r) {
                this.possui = true;
                return r;
            }
            System.out.print("esq ");
            search(i.left, s);
            System.out.print("dir ");
            search(i.right, s);

        }
        return r;
    }

    public void insertPos(TNode i, int x, Personagem p) {

        if (i == null) {
            System.out.println("Index not found");
        } else if (x == i.x) {
            i.BT.insert(i.BT.root, p);

        } else if (x < i.x) {

            insertPos(i.left, x, p);
        } else {

            insertPos(i.right, x, p);
        }

    }

    public void printTree(TNode i) {

        // i.BT.printTree(i.BT.root);
        // System.out.println(i.x);
        // i.BT.printTree(i.BT.root);
        if (i != null) {
            i.BT.printTree(i.BT.root);
            printTree(i.left);
            printTree(i.right);
        }
    }

}

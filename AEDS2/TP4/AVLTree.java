public class AVLTree {

    public AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    public boolean checkEmpty() {
        if (this.root == null) {
            return true;
        }
        return false;
    }

    public void insert(Personagem p) {
        this.root = insert(p, this.root);
    }

    private AVLNode insert(Personagem pe, AVLNode i) {
        if (i == null) {
            i = new AVLNode(pe);
        } else if (pe.getNome().compareTo(i.p.getNome()) < 0) {
            i.left = insert(pe, i.left);
            if (getHeight(i.left) - getHeight(i.right) == 2) {
                if (pe.getNome().compareTo(i.left.p.getNome()) < 0) {
                    i = sRotateLeft(i);
                } else {
                    i = dRotateLeft(i);
                }
            }
        } else if (pe.getNome().compareTo(i.p.getNome()) > 0) {
            i.right = insert(pe, i.right);
            if (getHeight(i.right) - getHeight(i.left) == 2) {
                if (pe.getNome().compareTo(i.right.p.getNome()) > 0) {
                    i = sRotateRight(i);
                } else {
                    i = dRotateRight(i);
                }
            }
        }
        i.h = getMaxHeight(getHeight(i.left), getHeight(i.right)) + 1;
        return i;

    }

    public AVLNode sRotateLeft(AVLNode i) {
        AVLNode n1 = i.left;
        i.left = n1.right;
        n1.right = i;
        i.h = getMaxHeight(getHeight(i.left), getHeight(i.right)) + 1;
        n1.h = getMaxHeight(getHeight(n1.left), i.h) + 1;
        return n1;
    }

    public AVLNode sRotateRight(AVLNode i) {
        AVLNode n1 = i.right;
        i.right = n1.left;
        n1.left = i;
        i.h = getMaxHeight(getHeight(i.left), getHeight(i.right)) + 1;
        n1.h = getMaxHeight(getHeight(n1.left), i.h) + 1;
        return n1;

    }

    public AVLNode dRotateLeft(AVLNode i) {
        i.left = sRotateRight(i.left);
        return sRotateLeft(i);
    }

    public AVLNode dRotateRight(AVLNode i) {
        i.right = sRotateLeft(i.right);
        return sRotateRight(i);
    }

    public int getHeight(AVLNode i) {
        if (i == null) {
            return -1;
        }
        return i.h;
    }

    public int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    public boolean searchElement(String s) {
        System.out.print("raiz ");
        return searchElement(this.root, s);
    }

    public boolean searchElement(AVLNode i, String s) {
        boolean check = false;
        if ((i != null) && !check) {
            AVLNode headElement = i;
            if (s.compareTo(headElement.p.getNome()) < 0) {
                System.out.print("esq ");
                check = searchElement(i.left, s);
            } else if (s.compareTo(headElement.p.getNome()) > 0) {

                System.out.print("dir ");
                check = searchElement(i.right, s);
            } else {
                check = true;
            }
        }
        return check;
    }

}
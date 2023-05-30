public class RBTree {

    public RBNode root;
    public RBNode TNULL;

    public RBTree() {
        TNULL = new RBNode();
        TNULL.color = false;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public void insert(Personagem pe) {

        RBNode node = new RBNode();
        node.p = pe.clone();
        node.left = TNULL;
        node.right = TNULL;
        node.color = true;
        RBNode y = null;
        RBNode x = this.root;
        while (x != TNULL) {
            y = x;
            if (node.p.getNome().compareTo(x.p.getNome()) < 0) {
                x = x.left;
            } else if (node.p.getNome().compareTo(x.p.getNome()) > 0) {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            this.root = node;
        } else if (node.p.getNome().compareTo(y.p.getNome()) < 0) {
            y.left = node;
        } else if (node.p.getNome().compareTo(y.p.getNome()) > 0) {
            y.right = node;
        }
        if (node.parent == null) {
            node.color = false;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }
        fixInsert(node);
    }

    private void fixInsert(RBNode k) {
        RBNode u;
        while (k.parent.color) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = false;
    }

    public void leftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(RBNode x) {
        RBNode y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    public boolean searchElement(RBNode i, String s) {
        boolean check = false;
        if ((i != TNULL) && !check) {
            RBNode headElement = i;
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
    public void printTree() {
        printHelper(this.root, "", true);
    }

    private void printHelper(RBNode root, String indent, boolean last) {
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color ? "RED" : "BLACK";
            System.out.println(root.p.getNome() + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

}
// 1.Red,0.Black
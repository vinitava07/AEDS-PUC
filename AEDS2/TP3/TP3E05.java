class NodeMatrix {

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

class MatrizDinamica {

    NodeMatrix begin;
    int lin;
    int col;

    MatrizDinamica() {

        this.begin = null;
        this.lin = 3;
        this.col = 3;

    }

    MatrizDinamica(int x, int y) {

        this.begin = null;
        this.lin = x;
        this.col = y;

    }

    // MatrizDinamica(int x, int y, int data) {

    // this.begin = new NodeMatrix(data);
    // this.lin = x;
    // this.col = y;

    // }

    public void createMatrix() {
        if (this.begin == null) {
            int contL = 0;
            int contC = 0;
            this.begin = new NodeMatrix(0);
            NodeMatrix aux = this.begin;
            NodeMatrix i = this.begin;
            NodeMatrix j;
            while (contC < this.col) {
                aux.right = new NodeMatrix(0);
                contL = 0;

                if (contC == 0) {
                    while (contL < this.lin - 1) {
                        i.down = new NodeMatrix(0);
                        // System.out.println(i.data);
                        i.down.up = i;
                        i = i.down;
                        contL++;
                    }
                    // System.out.println();
                } else {
                    aux.right.left = aux;
                    aux = aux.right;
                    i = aux;
                    j = i.left;
                    // System.out.print(j.data);
                    while (contL < this.lin - 1) {
                        i.down = new NodeMatrix(0);
                        // System.out.println(i.data);
                        i.left = j;
                        j.right = i;
                        i.down.up = i;
                        i = i.down;
                        j = j.down;
                        contL++;
                    }
                    i.left = j;
                    j.right = i;
                    i = i.down;
                    j = j.down;
                    // System.out.println();
                    // System.out.println();

                }

                contC++;

            }

        }
    }

    public void insertAt(int l, int c, int value) {

        NodeMatrix aux = this.begin;
        for (int j = 0; j < c; j++) {
            aux = aux.right;
        }
        for (int i = 0; i < l; i++) {

            aux = aux.down;
        }
        aux.data = value;

    }

    public MatrizDinamica sumMatrix(MatrizDinamica M) {
        MatrizDinamica tmp = new MatrizDinamica(this.lin, this.col);
        tmp.createMatrix();
        NodeMatrix aux = this.begin;
        NodeMatrix auxM = M.begin;
        NodeMatrix aux2 = this.begin;
        NodeMatrix auxM2 = M.begin;
        int soma = 0;
        for (int i = 0; i < this.lin; i++) {

            aux2 = aux;
            auxM2 = auxM;
            for (int j = 0; j < this.col; j++) {
                soma = aux2.data + auxM2.data;
                tmp.insertAt(i, j, soma);
                aux2 = aux2.right;
                auxM2 = auxM2.right;
            }

            aux = aux.down;
            auxM = auxM.down;

        }
        tmp.showMatrix();
        return tmp;
    }

    public MatrizDinamica multiplyMatrix(MatrizDinamica M) {
        MatrizDinamica tmp = new MatrizDinamica(this.lin, M.col);
        tmp.createMatrix();
        NodeMatrix bM = M.begin;
        NodeMatrix lm1 = this.begin;
        NodeMatrix cm1 = this.begin;
        NodeMatrix lm2 = M.begin;
        NodeMatrix cm2 = M.begin;

        int mult = 0;
        for (int i = 0; i < this.lin; i++) {

            cm2 = bM;

            for (int j = 0; j < M.col; j++) {

                cm1 = lm1;
                lm2 = cm2;

                for (int k = 0; k < this.col; k++) {
                    mult = mult + (lm2.data * cm1.data);
                    cm1 = cm1.right;
                    lm2 = lm2.down;
                    tmp.insertAt(i, j, mult);

                }
                mult = 0;
                cm2 = cm2.right;

            }
            lm1 = lm1.down;
        }
        tmp.showMatrix();
        return tmp;

    }

    public void showDiagonal() {
        NodeMatrix aux = this.begin;
        while (aux.right != null) {
            System.out.print(aux.data + " ");
            aux = aux.right.down;
        }
        System.out.print(aux.data);
        System.out.println();

    }

    public void showSecondaryDiagonal() {

        NodeMatrix aux = this.begin.right;
        while (aux.right != null) {
            aux = aux.right;

        }
        while (aux.left != null) {
            System.out.print(aux.data + " ");
            aux = aux.left.down;
        }
        System.out.print(aux.data);
        System.out.println();

    }

    public void showMatrix() {

        NodeMatrix aux = this.begin;
        NodeMatrix aux2 = this.begin;

        for (int i = 0; i < this.lin; i++) {
            aux = aux2;
            // System.out.println(aux.right.data);
            while (aux != null) {
                System.out.print(aux.data + " ");
                aux = aux.right;
            }
            aux2 = aux2.down;

            System.out.println();
        }

    }

}

public class TP3E05 {

    public static void main(String[] args) {

        int cont = 0;
        int lm1, cm1;
        int lm2, cm2;
        int data;

        MatrizDinamica m;
        MatrizDinamica m2;

        cont = MyIO.readInt();
        for (int i = 0; i < cont; i++) {
            lm1 = MyIO.readInt();
            cm1 = MyIO.readInt();
            m = new MatrizDinamica(lm1, cm1);
            m.createMatrix();

            for (int j = 0; j < lm1; j++) {
                for (int k = 0; k < cm1; k++) {
                    data = MyIO.readInt();
                    m.insertAt(j, k, data);
                }
            }
            lm2 = MyIO.readInt();
            cm2 = MyIO.readInt();
            m2 = new MatrizDinamica(lm2, cm2);
            m2.createMatrix();
            for (int j = 0; j < lm2; j++) {
                for (int k = 0; k < cm2; k++) {
                    data = MyIO.readInt();
                    m2.insertAt(j, k, data);
                }
            }
            m.showDiagonal();
            m.showSecondaryDiagonal();
            m.sumMatrix(m2);
            m.multiplyMatrix(m2);

        }
    }

}

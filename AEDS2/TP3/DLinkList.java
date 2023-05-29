import java.io.IOException;
import java.io.PrintStream;

class Node {

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

public class DLinkList {

    Node inicio;
    Node fim;
    public int size;

    DLinkList() {
        this.fim = null;
        this.inicio = null;
        this.size = 0;
    }

    public void inserirFim(Personagem pe) {

        Node tmp = new Node(pe);
        if (this.inicio == null) {

            this.inicio = tmp;
            this.fim = tmp;

        } else {
            this.fim.next = new Node(pe);
            this.fim.next.prev = this.fim;
            this.fim = this.fim.next;

        }
        this.size++;
    }

    public void removerFim() throws IOException {
        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
        Node aux = this.inicio;
        if (aux == null) {
            MyIO.println("Lista vazia");
        } else {
            while (aux.next.next != null) {
                aux = aux.next;
            }
            pt.println("(R) " + aux.next.p.getNome());
            aux.next = null;
        }
        this.size--;
    }

    public void inserirInicio(Personagem pe) {

        Node tmp = new Node(pe);
        Node aux = this.inicio;
        if (this.inicio == null) {

            this.inicio = tmp;
            this.fim = tmp;

        } else {
            this.inicio = new Node(pe);
            this.inicio.next = aux;

        }

    }

    public void removerInicio() throws IOException {
        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
        if (this.inicio == null) {
            MyIO.println("Lista vazia");
        } else {
            pt.println("(R) " + inicio.p.getNome());
            this.inicio = inicio.next;
        }
    }

    public void inserir(Personagem pe, int pos) {

        Node aux = this.inicio;
        Node tmp = new Node(pe);
        if (this.inicio == null) {

            this.inicio = tmp;
            this.fim = tmp;

        } else if (pos == 0) {
            inserirInicio(pe);
        } else {
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.next;
            }
            tmp.next = aux.next;
            aux.next = tmp;
        }
    }

    public void remover(int pos) throws IOException {
        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
        Node aux = this.inicio;
        if (this.inicio == null) {

            MyIO.println("Lista vazia");

        } else if (pos == 0) {
            removerInicio();
        } else {
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.next;
            }
            pt.println("(R) " + aux.next.p.getNome());
            aux.next = aux.next.next;
        }

    }

    public void swap(Node i, Node j) {
        Personagem tmp = i.p.clone();
        i.p = j.p.clone();
        j.p = tmp.clone();

    }

    public Node findMid(Node esq, Node dir) {
        Node aux = esq;
        Node aux2 = esq;

        while (aux2 != dir && aux2 != null && aux2.next != null) {
            aux = aux.next;
            aux2 = aux2.next.next;
        }
        System.out.println(aux.p.getNome());
        return aux;
    }

    public void quickSort(Node esq, Node dir) throws IOException {

        if (esq == dir) {
            System.out.println("ERRO");
        }
        Node pivo = findMid(esq, dir);
        Node i = esq;
        Node j = dir;

        Node aa = this.inicio;
        int x =0;
        int y = 0;
        int xx = 0;
        int yy = 0;
        while (aa != esq) {
            x++;
            xx++;
            aa = aa.next;
        }
        aa = inicio;

        while (aa != dir) {
            yy++;
            y++;
            aa = aa.next;
        }

        while (x <= y) {
            // System.out.println(j.p.getCorDoCabelo().compareTo(pivo.p.getCorDoCabelo()));
            // System.out.println(j.p.getCorDoCabelo());
            // System.out.println(pivo.p.getCorDoCabelo());

            while ((i.p.getCorDoCabelo().compareTo(pivo.p.getCorDoCabelo()) < 0 && x  < yy)) {
                i = i.next;
                x++;
              //  System.out.println("Menor");
            }
            while ( (j.p.getCorDoCabelo().compareTo(pivo.p.getCorDoCabelo()) > 0 && y > xx)) {
                j = j.prev;
                y--;
               // System.out.println("Maior");

            }
            if (x <= y) {
                // imprime();

               // System.out.println("Trocou");
                swap(i, j);
                x++;
                y--;
                i = i.next;
                j = j.prev;
                // imprime();

            }
        }
 
        if (y > xx) {

            quickSort(esq, j);

        }
        if (x < yy) {

            quickSort(i, dir);

        }

    }

    public void imprime() {

        Node aux = this.inicio;
        int i = 0;
        while (aux != null) {
           // MyIO.print("[" + i );
            aux.p.imprimir();
            aux = aux.next;
            i++;
        }

    }

}

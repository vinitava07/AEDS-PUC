import java.io.IOException;
import java.io.PrintStream;

public class LinkList {

    Node inicio;
    Node fim;

    LinkList() {
        this.fim = null;
        this.inicio = null;
    }

    public void inserirFim(Personagem pe) {

        Node tmp = new Node(pe);
        if (this.inicio == null) {

            this.inicio = tmp;
            this.fim = tmp;

        } else {
            this.fim.next = new Node(pe);
            this.fim = this.fim.next;
        }

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

    public void imprime() {

        Node aux = this.inicio;
        int i = 0;
        while (aux != null) {
            MyIO.print("[" + i + "] ");
            aux.p.imprimir();
            aux = aux.next;
            i++;

        }

    }

}

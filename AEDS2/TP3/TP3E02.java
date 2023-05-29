
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.File;

class Personagem {
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    Personagem() {
        // nothing here
    }

    Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
            String corDosOlhos, String anoNascimento, String genero, String homeworld) {

        this.setNome(nome);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setCorDoCabelo(corDoCabelo);
        this.setCorDaPele(corDaPele);
        this.setCorDosOlhos(corDosOlhos);
        this.setAnoNascimento(anoNascimento);
        this.setGenero(genero);
        this.setHomeworld(homeworld);
    }

    // sets - inicio
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }
    // sets - fim

    // gets - inicio
    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public String getCorDaPele() {
        return corDaPele;
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getHomeworld() {
        return homeworld;
    }

    // gets - fim
    public void ler(String diretorio) {

        try {
            RandomAccessFile arq = new RandomAccessFile(diretorio, "r");
            // File input = new File(diretorio);
            String texto = arq.readLine();
            setNome(parser(texto, 1));
            setAltura(Integer.parseInt(parser(texto, 2)));
            setPeso(Double.parseDouble(parser(texto, 3)));
            setCorDoCabelo(parser(texto, 4));
            setCorDaPele(parser(texto, 5));
            setCorDosOlhos(parser(texto, 6));
            setAnoNascimento(parser(texto, 7));
            setGenero(parser(texto, 8));
            setHomeworld(parser(texto, 9));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void imprimir() {
        try {

            PrintStream output = new PrintStream(System.out, true, "ISO-8859-1");
            output.print(" ## " + getNome() + " ## " + getAltura() + " ## ");
            if ((getPeso() % 1) == 0) {
                output.printf("%.0f", getPeso());
            } else
                output.print(getPeso());
            output.println(" ## " + getCorDoCabelo() + " ## " + getCorDaPele() + " ## " + getCorDosOlhos() + " ## "
                    + getAnoNascimento() + " ## " + getGenero() + " ## " + getHomeworld() + " ## ");

        } catch (UnsupportedEncodingException e) {

        }
    }

    public String parser(String s, int atributo) {

        int ptVirgula = 0;
        int inicio = 0;
        int i = 0;
        boolean ctr = true;

        do {
            if (s.charAt(i) == ':') {
                ptVirgula++;
            }
            if (ptVirgula == atributo) {
                inicio = i + 3;
                ctr = false;
            }
            i++;
        } while (ctr);
        return lePalavra(s, inicio, atributo);

    }

    public String lePalavra(String s, int inicio, int n) {
        boolean ctr = true;
        int i = inicio;
        while (ctr) {
            if (s.charAt(i) == 39) {

                ctr = false;
            }
            i++;

        }
        s = s.substring(inicio, i - 1);
        if (s.equals("unknown") && ((n == 3) || (n == 2))) {
            return "0";
        }

        if (n == 3) {
            s = s.replace(",", "");
            return s;
        }

        return s;

    }

    public Personagem clone() {

        Personagem p = new Personagem();
        p.setAltura(this.getAltura());
        p.setAnoNascimento(this.getAnoNascimento());
        p.setCorDaPele(this.getCorDaPele());
        p.setCorDoCabelo(this.getCorDoCabelo());
        p.setCorDosOlhos(this.getCorDosOlhos());
        p.setGenero(this.getGenero());
        p.setHomeworld(this.getHomeworld());
        p.setNome(this.getNome());
        p.setPeso(this.getPeso());

        return p;
    }
}

class Node {

    public Personagem p;
    public Node next;

    Node() {
        this.p = new Personagem();
        this.next = null;
    }

    Node(Personagem personagem) {
        this.p = personagem.clone();
        this.next = null;
    }

}

class LinkList {

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
            this.fim = aux;
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

public class TP3E02 {

    public static boolean ehFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void main(String[] args) throws IOException {
        MyIO.setCharset("UTF-8");
        try {
            PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");

        } catch (Exception e) {
            // TODO: handle exception
        }
        String str = MyIO.readLine();
        Personagem p = new Personagem();
        LinkList L = new LinkList();
        while (ehFim(str) == false) {
            p.ler(str);
            L.inserirFim(p);
            str = MyIO.readLine();
        }

        int max = Integer.parseInt(MyIO.readLine());
        String acao;
        int posicao;// Variavel de leitura para posicao de acoes
        for (int aux = 0; aux < max; aux++) {
            acao = MyIO.readString();// leitura acao

            if (acao.equals("R")) {
                L.removerFim();
            } else if (acao.equals("I")) {
                str = MyIO.readLine();
                p.ler(str);
                L.inserirFim(p);

            }

        }
        L.imprime();

    }
}
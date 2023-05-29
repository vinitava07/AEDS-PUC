import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import E2.BinaryTree;

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

    Node left;
    Node right;
    Personagem p;
    public String nome;

    Node() {
        this.left = null;
        this.right = null;
        p = new Personagem();
    }

    Node(Personagem pe) {
        this.left = null;
        this.right = null;
        p = pe.clone();

    }

}

class BinaryTree {

    Node root;
    public boolean possui;

    BinaryTree() {
        this.root = null;
    }

    public Node insert(Node i, Personagem pe) {

        if (this.root == null) {
            this.root = new Node(pe);
        } else if (i == null) {
            i = new Node(pe);
        } else if (pe.getNome().compareTo(i.p.getNome()) < 0) {

            i.left = insert(i.left, pe);

        } else if (pe.getNome().compareTo(i.p.getNome()) > 0) {
            i.right = insert(i.right, pe);

        }
        return i;
    }

    public boolean search(Node i, String s) {
        boolean r = true;
        if (i == null) {
            r = false;
        } else if (s.compareTo(i.p.getNome()) == 0) {
            r = true;
        } else if (s.compareTo(i.p.getNome()) < 0) {
            System.out.print("esq ");
            r = search(i.left, s);
        } else {
            System.out.print("dir ");
            r = search(i.right, s);
        }

        return r;
    }

    public void printTree(Node i) {
        if (i != null) {
            i.p.imprimir();
            printTree(i.left);
            printTree(i.right);
        }
    }

}

public class TP4E1 {
    public static void main(String[] args) throws IOException {
        MyIO.setCharset("ISO-8859-1");

        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");

        String str = MyIO.readLine();
        Personagem p = new Personagem();
        BinaryTree BT = new BinaryTree();
        while (str.equals("FIM") == false) {
            p.ler(str);
            BT.insert(BT.root, p);
            str = MyIO.readLine();
        }
        str = MyIO.readLine();
        boolean achou;
        while (str.equals("FIM") == false) {
            MyIO.print(str + " raiz ");
            achou = BT.search(BT.root, str);
            if (achou) {
                System.out.print("SIM");
            } else {
                MyIO.print( "N" + (char) 195 + "O");
            }
            System.out.println();
            str = MyIO.readLine();

        }
         //BT.printTree(BT.root);
    }

}

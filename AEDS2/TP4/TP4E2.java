import java.io.PrintStream;

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

class TNode {

    TNode left;
    TNode right;
    int x;
    BinaryTree BT;

    TNode() {
        this.left = null;
        this.right = null;
        this.x = 0;
        this.BT = null;
    }

    TNode(int num) {
        this.left = null;
        this.right = null;
        this.x = num;
        this.BT = new BinaryTree();

    }

}

class Node {

    Node left;
    Node right;
    public String nome;

    Node() {
        this.left = null;
        this.right = null;
        this.nome = "";
    }

    Node(Personagem pe) {
        this.left = null;
        this.right = null;
        this.nome = pe.getNome();

    }

}

class BinaryTree {

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

class DBinaryTree {

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
            if (!this.possui) {
                System.out.print("esq ");
                search(i.left, s);
                if (!this.possui) {
                    System.out.print("dir ");
                    search(i.right, s);

                }

            }

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

public class TP4E2 {

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");

        String str = MyIO.readLine();
        Personagem p = new Personagem();
        BinaryTree BT = new BinaryTree();
        DBinaryTree DBT = new DBinaryTree();
        int vetor[] = { 7, 3, 11, 1, 5, 9, 12, 0, 2, 4, 6, 8, 10, 13, 14 };
        for (int i = 0; i < 15; i++) {
            DBT.insert(DBT.root, vetor[i]);
        }
        // DBT.printTree(DBT.root);

        while (str.equals("FIM") == false) {
            p.ler(str);
            DBT.insertPos(DBT.root, p.getAltura() % 15, p);
            str = MyIO.readLine();
        }
        str = MyIO.readLine();
        while (str.equals("FIM") == false) {
            MyIO.print(str + " raiz ");
            DBT.search(DBT.root, str);
            if (DBT.possui) {
                System.out.print("SIM");
            } else {
                MyIO.print("NÃO");
            }
            DBT.possui = false;
            System.out.println();
            str = MyIO.readLine();
        }

    }

}

import java.io.IOException;
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

class RBNode {

    public RBNode left;
    public RBNode right;
    public RBNode parent;
    public Personagem p;
    public boolean color;

    public RBNode() {
        this.p = null;
        this.left = null;
        this.right = null;
        this.color = false;
        this.parent = null;

    }

    public RBNode(Personagem pe) {
        this(pe, null, null);
    }

    public RBNode(Personagem pe, RBNode lt, RBNode rt) {

        this.p = pe.clone();
        this.left = lt;
        this.right = rt;
        this.color = false;

    }

}

class RBTree {

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

public class TP4E4 {
    public static void main(String[] args) throws IOException {
        MyIO.setCharset("ISO-8859-1");

        String str = MyIO.readLine();
        Personagem p = new Personagem();
        RBTree RBT = new RBTree();
        while (str.equals("FIM") == false) {
            p.ler(str);
            RBT.insert(p);
            str = MyIO.readLine();
        }
        // RBT.printTree();
        // RBT.searchElement(RBT.root,"Ayla Secura");

        str = MyIO.readLine();
        while (str.equals("FIM") == false) {
            MyIO.print(str + " raiz ");
            if (RBT.searchElement(RBT.root, str)) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NÃO");

            }
            System.out.println();
            str = MyIO.readLine();
        }

    }

}
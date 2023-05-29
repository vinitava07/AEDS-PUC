import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

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

class AVLNode {

    Personagem p;
    int h;
    AVLNode left;
    AVLNode right;

    public AVLNode() {
        this.left = null;
        this.right = null;
        this.p = null;
        this.h = 0;
    }

    public AVLNode(Personagem pe) {
        this.left = null;
        this.right = null;
        this.p = pe.clone();
        this.h = 0;
    }

}

class AVLTree {

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

public class TP4E3 {
    public static void main(String[] args) throws IOException {
        MyIO.setCharset("ISO-8859-1");


        String str = MyIO.readLine();
        Personagem p = new Personagem();
        AVLTree AT = new AVLTree();
        while (str.equals("FIM") == false) {
            p.ler(str);
            AT.insert(p);
            str = MyIO.readLine();
        }
        str = MyIO.readLine();
        while (str.equals("FIM") == false) {
            MyIO.print(str + " ");
            if (AT.searchElement(str)) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NÃO");

            }
            System.out.println();
            str = MyIO.readLine();
        }

        // AT.searchElement("Ayla Secura");
    }

}

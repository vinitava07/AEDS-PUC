import java.io.*;
import java.util.*;

import javax.swing.text.PlainDocument;

import java.io.*;

class Lista {

    Personagem[] pL;
    int cont;
    int comp;
    int mov;

    Lista() {

        this.cont = 0;
        this.pL = new Personagem[100];
        this.comp = 0;
        this.mov = 0;
    }

    public void inserirFim(Personagem p) {

        pL[this.cont++] = p.clone();

    }

    public void inserirInicio(Personagem p) {

        Personagem aux = new Personagem();
        for (int i = cont; i > 0; i--) {
            aux = pL[i - 1].clone();
            pL[i] = aux.clone();

        }
        pL[0] = p.clone();
        cont++;
    }

    public void inserir(Personagem p, int pos) {

        Personagem aux = new Personagem();
        for (int i = this.cont; i > pos; i--) {
            aux = pL[i - 1].clone();
            pL[i] = aux.clone();

        }
        pL[pos] = p.clone();
        cont++;

    }

    public Personagem removerFim() throws IOException {
        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
        this.cont--;
        pt.println("(R) " + pL[this.cont].getNome());

        return this.pL[this.cont];
    }

    public Personagem removerInicio() throws IOException {
        Personagem aux = new Personagem();
        Personagem ret = pL[0].clone();
        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");

        pt.println("(R) " + pL[0].getNome());
        for (int i = 0; i < this.cont - 1; i++) {
            aux = pL[i + 1].clone();
            pL[i] = aux.clone();

        }
        this.cont--;

        return ret;
    }

    public Personagem remover(int pos) throws IOException {

        Personagem aux = new Personagem();
        Personagem ret = pL[pos].clone();

        PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
        pt.println("(R) " + pL[pos].getNome());
        for (int i = pos; i < this.cont - 1; i++) {
            aux = pL[i + 1].clone();
            pL[i] = aux.clone();

        }
        this.cont--;

        return ret;
    }

    public boolean busca(String nome) {

        boolean achou = false;
        int i = 0;
        while (!achou && i < this.cont) {

            if (pL[i].getNome().equals(nome)) {

                achou = true;

            }
            i++;

        }

        return achou;
    }

    public void selectionSort() {

        int min = 0;
        Personagem aux = new Personagem();
        for (int i = 0; i < this.cont; i++) {
            min = i;
            for (int j = i + 1; j < this.cont; j++) {
                if (this.pL[j].getNome().compareTo(this.pL[min].getNome()) < 0) {
                    min = j;
                }
                this.comp++;
            }
            if (i != min) {
                aux = this.pL[i].clone();
                this.pL[i] = this.pL[min].clone();
                this.pL[min] = aux.clone();
                this.mov++;
            }
        }
    }

    public void insertionSort() {

        int j = 0;
        Personagem key;

        for (int i = 1; i < this.cont; i++) {

            key = this.pL[i].clone();
            j = i - 1;

            while (j >= 0 && this.pL[j].getAnoNascimento().compareTo(key.getAnoNascimento()) > 0) {
                this.pL[j + 1] = this.pL[j].clone();
                j--;
                this.comp++;
                this.mov++;
            }

            this.pL[j + 1] = key.clone();
            this.mov++;
        }

    }

    public void heapSort() {
        int tam = this.cont;
        int i = tam / 2;
        int pai, filho;
        Personagem p;
        while (true) {

            if (i > 0) {
                i--;
                p = this.pL[i].clone();
            } else {
                tam--;
                if (tam <= 0) {
                    // p = this.pL[1].clone();
                    // this.pL[1] = this.pL[0].clone();
                    // this.pL[0] = p.clone();
                    return;
                }

                p = this.pL[tam].clone();
                this.pL[tam] = this.pL[0];
            }
            pai = i;
            filho = ((i * 2) + 1);
            while (filho < tam) {
                if (filho + 1 < tam && (pL[filho + 1].getAltura() > this.pL[filho].getAltura())) {
                    filho++;
                }
                if (this.pL[filho].getAltura() == p.getAltura()) {
                    if (this.pL[filho].getNome().compareTo(p.getNome()) < 0) {
                        this.pL[pai] = this.pL[filho].clone();
                        pai = filho;
                        filho = pai * 2 + 1;
                        System.out.println("NOme maior: ");
                    }
                } else if (this.pL[filho].getAltura() < p.getAltura()) {

                } else if (this.pL[filho].getAltura() > p.getAltura()) {
                    this.pL[pai] = this.pL[filho].clone();
                    pai = filho;
                    filho = pai * 2 + 1;
                } else {
                    break;
                }
            }
            this.pL[pai] = p.clone();

        }

    }

    public void heapSort2() {
        Personagem[] p = new Personagem[this.cont + 1];

        for (int i = 0; i < this.cont; i++) {
            p[i + 1] = pL[i].clone();
        }
        // pL = p;
        // Contrucao do heap
        for (int tamHeap = 2; tamHeap < this.cont; tamHeap++) {
            construir(tamHeap);
        }
        int tamHeap = this.cont-1;
        while (tamHeap > 1) {
            System.out.println("chamou");

            swap(1, tamHeap--);
            reconstruir(tamHeap);
        }
        // tmp = array;
        // array = new int[n];
        for (int i = 0; i < this.cont; i++) {
            pL[i] = p[i + 1].clone();
        }
    }

    public void swap(int i, int j) {

        System.out.println("j " + j);
        System.out.println("i " + i);


        Personagem temp = this.pL[i].clone();
        this.pL[i] = this.pL[j].clone();
        this.pL[j] = temp.clone();
    }

    public void construir(int tamHeap) {
        for (int i = tamHeap; i > 1 && pL[i].getAltura() > pL[i / 2].getAltura(); i /= 2) {
            // if( i == 2) {
            // break;
            // }
            // System.out.println("tam heap: " + tamHeap);

            System.out.println(i/2);

            swap(i, i / 2);
        }
    }

    public void reconstruir(int tamHeap) {
        int i = 1;
        while (i <= (tamHeap / 2)) {
            int filho = getMaiorFilho(i, tamHeap);
            if (pL[i].getAltura() < pL[filho].getAltura()) {
                System.out.println("chamou");
                swap(i, filho);
                i = filho;
            } else {
                i = tamHeap;
            }
        }
    }

    public int getMaiorFilho(int i, int tamHeap) {
        int filho;
        if (2 * i == tamHeap || pL[2 * i].getAltura() > pL[2 * i + 1].getAltura()) {
            filho = 2 * i;
        } else {
            filho = 2 * i + 1;
        }
        return filho;
    }

    public void escreve() {
        for (int i = 0; i < this.cont; i++) {
            pL[i].imprimir();
        }
    }

}

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

public class TP2E13 {

    public static void main(String[] args) throws IOException {
        MyIO.setCharset("UTF-8");
        String str = MyIO.readLine();
        Personagem personagem1 = new Personagem();
        Lista l = new Lista();
        FileWriter fw = new FileWriter("Vinicius_784759_insertion.txt");
        PrintWriter pw = new PrintWriter(fw);

        while (!str.equals("FIM")) {
            personagem1.ler(str);
            l.inserirFim(personagem1);
            str = MyIO.readLine();
        }
        long inicio = new Date().getTime();
        l.heapSort2();
        long fim = new Date().getTime();
        pw.print("784759\t" + l.comp + "\t" + l.mov + "\t" + (fim - inicio));
        // l.escreve();
        // System.out.println(l.pL[0].getNome());
        pw.close();
        fw.close();
    }

}

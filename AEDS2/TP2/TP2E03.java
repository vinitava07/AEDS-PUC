
import java.io.*;

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
                ptVirgula++;    /* data */

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

class Lista {

    Personagem[] pL = new Personagem[100];
    int cont;

    Lista() {

        this.cont = 0;
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

    public Personagem removerFim() {
        try {
            PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
            this.cont--;
            pt.println("(R) " + pL[this.cont].getNome());

        } catch (Exception e) {
            // TODO: handle exception
        }

        return this.pL[this.cont];
    }

    public Personagem removerInicio() {
        Personagem aux = new Personagem();
        Personagem ret = pL[0].clone();
        try {
            PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");

            pt.println("(R) " + pL[0].getNome());
            for (int i = 0; i < this.cont - 1; i++) {
                aux = pL[i + 1].clone();
                pL[i] = aux.clone();

            }
            this.cont--;

        } catch (Exception e) {
            // TODO: handle exception
        }

        return ret;
    }

    public Personagem remover(int pos) {

        Personagem aux = new Personagem();
        Personagem ret = pL[pos].clone();
        try {

            PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");
            pt.println("(R) " + pL[pos].getNome());
            for (int i = pos; i < this.cont - 1; i++) {
                aux = pL[i + 1].clone();
                pL[i] = aux.clone();

            }
            this.cont--;
        } catch (Exception e) {
            // TODO: handle exception
        }

        return ret;
    }

    public void escreve() {
        for (int i = 0; i < this.cont; i++) {
            System.out.print("[" + i + "] ");
            pL[i].imprimir();
        }
    }

}

public class TP2E03 {

    public static boolean ehFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        try {
            PrintStream pt = new PrintStream(System.out, true, "ISO-8859-1");

        } catch (Exception e) {
            // TODO: handle exception
        }
        String str = MyIO.readLine();
        Personagem p = new Personagem();
        Lista L = new Lista();
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

            if (acao.equals("R*")) {
                posicao = MyIO.readInt();// leitura da posicao do personagem a ser removido
                L.remover(posicao);
            } else {
                if (acao.equals("RF")) {
                    L.removerFim();
                } else {
                    if (acao.equals("RI")) {
                        L.removerInicio();
                    } else {
                        if (acao.equals("I*")) {
                            posicao = MyIO.readInt();// Leitura da posicao da insercao
                            str = MyIO.readLine();
                            p.ler(str);
                            L.inserir(p, posicao);
                        } else {
                            if (acao.equals("II")) {
                                str = MyIO.readLine();
                                p.ler(str);
                                L.inserirInicio(p);
                            } else {
                                str = MyIO.readLine();
                                p.ler(str);
                                L.inserirFim(p);
                            }
                        }
                    }
                }
            }
        }
        L.escreve();

    }
}

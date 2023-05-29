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
                if (this.pL[filho].getAltura() >= p.getAltura()) {
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

    int getMax() {
        double max = (this.pL[0].getPeso());
        for (int i = 1; i < this.cont; i++) {
            if (this.pL[i].getPeso() > max)
                max = (int) this.pL[i].getPeso();

        }
        return (int) max; // maximum element from the array
    }

    public void countingSort() {
        {
            Personagem[] saida = new Personagem[this.cont + 1];
            int max = getMax();
            // max = 300;
            Personagem[] count = new Personagem[max + 1]; // create count array with size [max+1]
            for (int i = 0; i <= max; ++i) {
                count[i] = new Personagem();
                count[i].setPeso(0); // Initialize count array with all zeros
            }
            for (int i = 0; i < this.cont; i++) // Store the count of each element
            {
                count[(int) this.pL[i].getPeso()].setPeso((count[(int) this.pL[i].getPeso()].getPeso() + 1));
                //

            }

            for (int i = 1; i <= max; i++) {
                count[i].setPeso(count[i - 1].getPeso() + count[i].getPeso());
            }

            for (int i = this.cont - 1; i >= 0; i--) {
                saida[(int) count[(int) pL[i].getPeso()].getPeso() - 1] = new Personagem();

                saida[(int) count[(int) pL[i].getPeso()].getPeso() - 1] = this.pL[i].clone();

                count[(int) pL[i].getPeso()].setPeso((int) count[(int) pL[i].getPeso()].getPeso() - 1);
            }

            for (int i = 0; i < this.cont; i++) {
                pL[i] = saida[i].clone();
            }
        }

    }

    public void mergeSort(int esq, int dir) {

        if (esq < dir) {
            int meio = ((esq + dir) / 2);

            mergeSort(esq, meio);
            mergeSort(meio + 1, dir);

            merge(esq, meio, dir);
        }

    }

    public void merge(int esq, int meio, int dir) {

        int i, j, k;
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        Personagem[] left = new Personagem[n1];
        Personagem[] right = new Personagem[n2];

        for (i = 0; i < n1; i++) {
            left[i] = this.pL[esq + i].clone();
        }
        for (j = 0; j < n2; j++) {
            right[j] = this.pL[meio + j + 1].clone();
        }

        i = j = 0;
        k = esq;
        while (i < n1 && j < n2) {
            if (left[i].getHomeworld().compareTo(right[j].getHomeworld()) <= 0) {
                this.comp++;
                pL[k] = left[i].clone();
                this.mov++;
                i++;
            } else {
                pL[k] = right[j].clone();
                this.mov++;

                j++;
            }
            k++;
        }

        while (i < n1) {
            pL[k] = left[i].clone();
            i++;
            k++;
            this.mov++;

        }

        while (j < n2) {
            pL[k] = right[j].clone();
            j++;
            k++;
            this.mov++;

        }

    }

    public void merge2(int esq, int meio, int dir) {
        Personagem[] aux = new Personagem[this.cont];

        for (int i = esq; i < dir; i++) {
            aux[i] = this.pL[i].clone();
        }
        int i = esq;
        int j = meio + 1;
        int k = esq;

        while (i <= meio && j <= dir) {
            if (aux[i].getHomeworld().compareTo(aux[j].getHomeworld()) < 0) {
                this.pL[k] = aux[i].clone();
                i++;
            } else {
                this.pL[k] = aux[j].clone();
                j++;
            }
            k++;
        }
        while (i <= meio) {
            this.pL[k] = aux[i].clone();
            i++;
            k++;
        }
        while (j <= dir) {
            this.pL[k] = aux[j].clone();
            j++;
            k++;
        }

    }

    public void escreve() {
        for (int i = 0; i < this.cont; i++) {
            pL[i].imprimir();
        }
    }

}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>
#include <time.h>

typedef struct
{
    char nome[200];
    int altura;
    double peso;
    char corDoCabelo[200];
    char corDaPele[200];
    char corDosOlhos[200];
    char anoNascimento[200];
    char genero[200];
    char homeworld[200];

} Personagem;
typedef struct
{

    Personagem *pL[100];
    int cont;
    int comp;
    int mov;

} Lista;

bool isFim(char *palavra)
{
    bool result = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        result = true;
    }

    return result;
}
int criaPersonagem(Personagem *personagem1, int altura, char *nome, char *corDoCabelo, char *corDaPele, char *corDosOlhos, char *anoNascimento, char *genero, char *homeworld, double peso)
{

    // personagem1->nome = nome;
    // personagem1->altura = altura;
    // personagem1->peso = peso;
    // personagem1->corDoCabelo = corDoCabelo;
    // personagem1->corDaPele = corDaPele;
    // personagem1->genero = genero;
    // personagem1->homeworld = homeworld;

    return 0;
}

int multiplicador(char A)
{
    switch (A)
    {
    case '0':
        return 0;
        break;
    case '1':
        return 1;
        break;
    case '2':
        return 2;
        break;
    case '3':
        return 3;
        break;
    case '4':
        return 4;
        break;
    case '5':
        return 5;
        break;
    case '6':
        return 6;
        break;
    case '7':
        return 7;
        break;
    case '8':
        return 8;
        break;
    case '9':
        return 9;
        break;
    default:
        break;
    }
    return 0;
}
int ipow(int base, int exp)
{
    int result = 1;
    for (int i = 0; i < exp; i++)
    {
        result *= base;
    }
    return result;
}
void subString(char *s, char *novaString, int inicio, int atributo)
{

    int i = inicio;
    int j = 0;

    if (atributo == 3)
    {
        while (s[i] != 39)
        {

            if (s[i] == ',')
            {
                i++;
            }
            else
            {
                novaString[j] = s[i];
                i++;
                j++;
            }
        }
    }
    else
    {
        while (s[i] != 39)
        {
            novaString[j] = s[i];
            i++;
            j++;
        }
    }

    novaString[j] = '\0';
}
int parseInt(char *s)
{

    if (strcmp(s, "unknown"))
    {
        int total = 0;
        int casa = strlen(s) - 1;
        for (int i = 0; i < strlen(s); i++)
        {
            total += multiplicador(s[i]) * (int)(ipow(10, (casa)));
            casa--;
        }
        return total;
    }
    return 0;
}

int parser(char *s, char *stringNova, int atributo)
{

    int ptVirgula = 0;
    int inicio = 0;
    int i = 0;
    int j = 0;
    bool ctr = true;
    do
    {
        if (s[i] == ':')
        {
            ptVirgula++;
        }
        if (ptVirgula == atributo)
        {
            inicio = i + 3;
            ctr = false;
        }
        i++;
    } while (ctr);
    subString(s, stringNova, inicio, atributo);
    if (atributo == 2)
    {
        subString(s, stringNova, inicio, atributo);
        return parseInt(stringNova);
    }
    return 0;
}
double parseDouble(char *s, char *atbDouble, int atributo)
{
    char *ptr;
    parser(s, atbDouble, atributo);
    return strtod(atbDouble, &ptr);
}

void lerPersonagem(Personagem *personagem1, char *arq)
{

    char str[1000];
    char nome[200];
    int altura;
    char alturatxt[200];
    double peso;
    char pesotxt[200];
    char corDoCabelo[200];
    char corDaPele[200];
    char corDosOlhos[200];
    char anoNascimento[200];
    char genero[200];
    char homeworld[200];
    FILE *f1 = fopen(arq, "r");
    int i = 0;
    if (!f1)
    {
        printf("erro");
    }
    else
    {
        do
        {
            str[i] = fgetc(f1);

        } while (str[i++] != EOF);
        parser(str, nome, 1);
        altura = parser(str, alturatxt, 2);
        peso = parseDouble(str, pesotxt, 3);
        parser(str, corDoCabelo, 4);
        parser(str, corDaPele, 5);
        parser(str, corDosOlhos, 6);
        parser(str, anoNascimento, 7);
        parser(str, genero, 8);
        parser(str, homeworld, 9);
        strcpy(personagem1->nome, nome);
        personagem1->altura = altura;
        personagem1->peso = peso;
        strcpy(personagem1->corDoCabelo, corDoCabelo);
        strcpy(personagem1->corDaPele, corDaPele);
        strcpy(personagem1->corDosOlhos, corDosOlhos);
        strcpy(personagem1->anoNascimento, anoNascimento);
        strcpy(personagem1->genero, genero);
        strcpy(personagem1->homeworld, homeworld);

        // printf("nome: %s",personagem1->nome);
        // fclose(f1);
    }
    fclose(f1);
}
void imprimir(Personagem *personagem1)
{

    printf(" ## %s ## %d ## %.6g ## %s ## %s ## %s ## %s ## %s ## %s ## \n", personagem1->nome, personagem1->altura, personagem1->peso, personagem1->corDoCabelo, personagem1->corDaPele, personagem1->corDosOlhos, personagem1->anoNascimento, personagem1->genero, personagem1->homeworld);
}
void inserirFim(Personagem *p, Lista *l)
{
    l->pL[l->cont++] = p;
}
void inserirInicio(Personagem *p, Lista *l)
{

    for (int i = l->cont; i > 0; i--)
    {
        l->pL[i] = l->pL[i - 1];
    }
    l->pL[0] = p;
    l->cont++;
}
void inserir(Personagem *p, Lista *l, int pos)
{

    for (int i = l->cont; i > pos; i--)
    {
        l->pL[i] = l->pL[i - 1];
    }
    l->pL[pos] = p;
    l->cont++;
}
Personagem *removerFim(Lista *l)
{

    l->cont--;
    printf("(R) %s\n", l->pL[l->cont]->nome);
    return l->pL[l->cont];
}
Personagem *removerInicio(Lista *l)
{
    Personagem *ret = l->pL[0];
    printf("(R) %s\n", l->pL[0]->nome);
    for (int i = 0; i < l->cont - 1; i++)
    {
        l->pL[i] = l->pL[i + 1];
    }
    l->cont--;

    return ret;
}
Personagem *remover(Lista *l, int pos)

{

    Personagem *ret = l->pL[pos];
    printf("(R) %s\n", l->pL[pos]->nome);
    for (int i = pos; i < l->cont - 1; i++)
    {
        l->pL[i] = l->pL[i + 1];
    }
    l->cont--;

    return ret;
}

void selectionSort(Lista *l, int i)
{

    int min = i;
    Personagem *aux;
    if (i < l->cont - 1)
    {
        for (int j = i + 1; j < l->cont; j++)
        {
            if (strcmp(l->pL[j]->nome, l->pL[min]->nome) < 0)
            {
                min = j;
            }
            l->comp++;
        }
        if (min != i)
        {
            aux = l->pL[i];
            l->pL[i] = l->pL[min];
            l->pL[min] = aux;
            l->mov++;
        }
        selectionSort(l, i + 1);
    }
}

void shellSort(Lista *l)
{
    int i, j;
    Personagem *aux;
    int h = 1;

    for (h = 1; h < l->cont; h = (l->cont * h) + 1)
    {
    }

    while (h > 0)
    {
        h = (h - 1) / l->cont;
        for (int i = h; i < l->cont; i++)
        {

            aux = l->pL[i];
            j = i;

            while (l->pL[j - h]->peso > aux->peso)
            {

                l->pL[j] = l->pL[j - h];
                l->mov++;
                j = j - h;
                if (j < h)
                {
                    break;
                }
                l->comp++;
            }
            l->pL[j] = aux;
            l->mov++;
        }
    }
}

void shellSort2(Lista *l)
{
    int j;
    int h = 1;
    int n = l->cont;
    Personagem *aux;
    do
    {
        h = h * 3 + 1;
    } while (h < n);
    do
    {
        h /= 3;
        for (int cor = 0; cor < h; cor++)
        {
            for (int i = (h + cor); i < n; i++)
            {
                aux = l->pL[i];
                j = i - h;
                while ((j >= 0) && l->pL[j]->peso > aux->peso)
                {
                    l->pL[j + h] = l->pL[j];
                    j -= h;
                }
                l->pL[j + h] = aux;
            }
        }

    } while (h != 1);
}

void quickSort(Lista *l, int esq, int dir)
{

    int i, j;
    i = esq;
    j = dir;
    Personagem *pivo = l->pL[(esq + dir) / 2];
    Personagem *aux;
    while (i <= j)
    {
        while (strcmp(l->pL[i]->corDoCabelo, pivo->corDoCabelo) < 0 && i < dir)
        {
            i++;
            l->comp++;
        }
        while (strcmp(l->pL[j]->corDoCabelo, pivo->corDoCabelo) > 0 && j > esq)
        {
            j--;
            l->comp++;
        }
        if (i <= j)
        {
            aux = l->pL[i];
            l->pL[i] = l->pL[j];
            l->pL[j] = aux;
            i++;
            j--;
            l->mov++;
        }
    }
    if (j > esq)
    {
        quickSort(l, esq, j);
    }
    if (i < dir)
    {
        quickSort(l, i, dir);
    }
}

void bubbleSort(Lista *l)
{

    Personagem *aux;

    for (int i = 0; i < l->cont; i++)
    {
        for (int j = 0; j < l->cont - 1; j++)
        {
            if (strcmp(l->pL[j]->anoNascimento, l->pL[j + 1]->anoNascimento) > 0)
            {
                aux = l->pL[j];
                l->pL[j] = l->pL[j + 1];
                l->pL[j + 1] = aux;
            }
        }
    }
}

void radixSort(Lista *l)
{
    int i;
    Personagem *p[l->cont];
    Personagem *cp;
    int maior = l->pL[0]->altura;
    int exp = 1;

    for (int i = 0; i < l->cont; i++)
    {
        cp = (Personagem *)malloc(sizeof(Personagem));
        cp->altura = l->pL[i]->altura;
        cp->peso = l->pL[i]->peso;
        strcpy(cp->corDoCabelo, l->pL[i]->corDoCabelo);
        strcpy(cp->corDaPele, l->pL[i]->corDaPele);
        strcpy(cp->corDosOlhos, l->pL[i]->corDosOlhos);
        strcpy(cp->anoNascimento, l->pL[i]->anoNascimento);
        strcpy(cp->genero, l->pL[i]->genero);
        strcpy(cp->homeworld, l->pL[i]->homeworld);
        p[i] = cp;
    }

    for (int i = 0; i < l->cont; i++)
    {
        if (l->pL[i]->altura > maior)
        {
            maior = l->pL[i]->altura;
        }
    }
    int n = 0;
    while (maior / exp > 0)
    {
        int bucket[10] = {0};

        for (int i = 0; i < l->cont; i++)
        {
            bucket[(l->pL[i]->altura / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++)
        {
            bucket[i] += bucket[i - 1];
        }
        for (int i = l->cont - 1; i >= 0; i--)
        {
            p[(bucket[(l->pL[i]->altura / exp) % 10]-1)] = l->pL[i];
            bucket[(l->pL[i]->altura / exp) % 10]--;
            // printf(" bucket %d\n", bucket[(l->pL[i]->altura / exp) % 10]);
        }
        for (int i = 0; i < l->cont; i++)
        {
            l->pL[i] = p[i];
        }
        n++;
        exp *= 10;
    }
}
void insertionSort(Lista *l) {

    Personagem* aux;
    int j;
    for (int i = 1; i < l->cont; i++)
    {
        aux = l->pL[i];
        j = ( i < 10) ? i-1 : 10-1;
        while ((j >= 0) && (strcmp(l->pL[j]->anoNascimento,aux->anoNascimento) > 0))
        {
            l->pL[j + 1] = l->pL[j];
            j--;
        }
        l->pL[j+1] = aux;

    }
    

}


void imprimeLista(Lista *l)
{

    for (int i = 0; i < 10; i++)
    {
        imprimir(l->pL[i]);
    }
}

int main()
{
    Personagem *personagem1;
    Lista L;
    time_t inc;
    time_t fim;
    L.cont = 0;
    L.comp = 0;
    L.mov = 0;
    char filePathInput[1000];

    scanf("%s", filePathInput);
    while (!isFim(filePathInput))
    {
        personagem1 = (Personagem *)malloc(sizeof(Personagem));
        lerPersonagem(personagem1, filePathInput);
        inserirFim(personagem1, &L);
        scanf("%s", filePathInput);
    }
    FILE *fw = fopen("784759_insertionSortParcial.txt", "w");
    inc = time(NULL);

    insertionSort(&L);
    // Personagem *aux;
    // for (int i = 0; i < L.cont; i++)
    // {
    //     for (int j = i; j < L.cont; j++)
    //     {
    //         if (strcmp(L.pL[i]->anoNascimento, L.pL[j]->anoNascimento) == 0)
    //         {

    //             if (strcmp(L.pL[j]->nome, L.pL[i]->nome) < 0)
    //             {
    //                 aux = L.pL[i];
    //                 L.pL[i] = L.pL[j];
    //                 L.pL[j] = aux;
    //             }
    //         }
    //     }
    // }

    fim = time(NULL);
    fprintf(fw, "784759\t%d\t%d\t%ld", L.comp, L.mov, fim - inc);
    imprimeLista(&L);
    fclose(fw);
    return 0;
}
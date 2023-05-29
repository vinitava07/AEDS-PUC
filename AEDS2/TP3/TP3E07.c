#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

struct Node
{
    Personagem *p;
    struct Node *next;
    struct Node *prev;
};
typedef struct Node Node;

typedef struct
{

    Node *inicio;
    Node *fim;
    int size;

} DLinkedList;

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

Node criarNode(Personagem *pe)
{

    Node no;
    no.p = pe;
    no.next = NULL;
    no.prev = NULL;

    return no;
}

void inserirFim(Personagem *pe, DLinkedList *l)
{

    Node *tmp = (Node *)malloc(sizeof(Node));
    tmp->p = pe;
    if (l->inicio == NULL)
    {
        l->inicio = tmp;
        l->fim = tmp;
        l->inicio->prev = NULL;
    }
    else
    {
        l->fim->next = tmp;
        tmp->prev = l->fim;
        l->fim = l->fim->next;
        l->fim->next = NULL;
    }
    l->size++;
}

void removerFim(DLinkedList *l)
{

    Node *tmp = l->fim;
    printf("(R) %s\n", tmp->p->nome);

    if (l->fim == NULL || l->inicio == NULL)
    {
        printf("Lista Vazia\n");
    }
    else
    {
        l->fim = l->fim->prev;
        l->fim->next = NULL;
    }
    free(tmp->p);
    free(tmp);
    l->size--;
}
Node *findMid(Node *head)
{
    Node *slow = head;
    Node *fast = head->next;

    while (!slow->next && (!fast && !fast->next))
    {
        slow = slow->next;
        fast = fast->next->next;
    }
}

void quickSort(DLinkedList *l, int esq, int dir, Node *meio)
{

    int i, j;
    i = esq;
    j = dir;
    Node *pivo = findMid(meio);
    Node *auxI = l->inicio;
    Node *auxJ = l->fim;
    Node *tmp;

    while (i <= j)
    {
        while (strcmp(auxI->p->corDoCabelo, pivo->p->corDoCabelo) < 0 && i < dir)
        {
            i++;
            auxI = auxI->next;
        }
        while (strcmp(auxJ->p->corDoCabelo, pivo->p->corDoCabelo) > 0 && j > esq)
        {
            j++;
            auxJ = auxJ->prev;
        }
        if (i <= j)
        {
            tmp = auxI;
            auxI = auxJ;
            auxJ = tmp;
            i++;
            j--;
        }
    }
    // if (j > esq)
    // {
    //     quickSort(l, esq, j, l->inicio);
    // }
    // if (i < dir)
    // {
    //     quickSort(l, i, dir, pivo->next);
    // }
}

void swap(Node *a, Node *b)
{
    Personagem *temp = a->p;
    a->p = b->p;
    b->p = temp;
}

Node *partition(Node *low, Node *high)
{
    Personagem *pivot = high->p;
    Node *i = low->prev;
    for (Node *j = low; j != high; j = j->next)
    {
        if (strcmp(j->p->corDoCabelo, pivot->corDoCabelo) < 0)
        {
            i = (i == NULL) ? low : i->next;
            swap(i, j);
        }
    }
    i = (i == NULL) ? low : i->next;
    swap(i, high);
    return i;
}

void quicksort(Node *low, Node *high)
{
    if (high != NULL && low != high && low != high->next)
    {
        Node *pi = partition(low, high);
        quicksort(low, pi->prev);
        quicksort(pi->next, high);
    }
}

void imprimeLista(DLinkedList *l)
{

    Node *aux = l->inicio;
    int i = 0;

    while (aux != NULL)
    {
        imprimir(aux->p);
        aux = aux->next;
        i++;
    }
}

int main()
{
    Personagem *personagem1;
    DLinkedList L;
    L.inicio = NULL;
    L.fim = NULL;
    L.size = 0;
    time_t inc;
    time_t fim;

    char filePathInput[1000];

    scanf("%s", filePathInput);
    while (!isFim(filePathInput))
    {
        personagem1 = (Personagem *)malloc(sizeof(Personagem));
        lerPersonagem(personagem1, filePathInput);
        inserirFim(personagem1, &L);
        scanf("%s", filePathInput);
    }
    quicksort(L.inicio, L.fim);
    Node *auxI = L.inicio;
    Node *auxJ;

    for (int i = 0; i < L.size; i++)
    {
        auxJ = auxI;
        for (int j = i; j < L.size; j++)
        {

            if (strcmp(auxI->p->corDoCabelo, auxJ->p->corDoCabelo) == 0)
            {
                if (strcmp(auxJ->p->nome, auxI->p->nome) < 0)
                {
                    swap(auxI, auxJ);
                }
            }
            auxJ = auxJ->next;
        }
        auxI = auxI->next;
    }
    imprimeLista(&L);
    return 0;
}
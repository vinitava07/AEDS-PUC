#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#define TAM 8;

void mergesort(int lista[], int inicio, int fim);
void merge(int lista[], int inicio, int meio, int fim);

int main()
{
    int lista[7] = {1, 3, 0, 2, 5, 4, 7};
    mergesort(lista, 0, 7);
    for (size_t i = 0; i < 7; i++)
    {
        printf("%d ",lista[i]);
    }

    return 0;
}

void mergesort(int lista[], int inicio, int fim)
{
    int meio;
    if (l < r)
    {
        meio = (fim + inicio) / 2;
        
        mergesort(lista, inicio, meio);
        mergesort(lista, meio, fim);
        merge(lista, inicio, meio, fim);
    }
    
}
void merge(int lista[], int inicio, int meio, int fim)
{
    int tam = fim - meio;
    int esquerda[tam];
    int direita[tam];
    int j = 0;
    int dir = 0, esq = 0;
    // printf("inicio %d ",inicio);
    printf("e:");
    for (int i = inicio; i < meio; i++)
    {
        esquerda[j] = lista[i];
        printf(" ( %d )", esquerda[j]);
        j++;
    }
    printf("\n");
    printf("d:");
    j=0;
    for (int i = meio; i < fim; i++)
    {
        direita[j] = lista[i];
        printf(" ( %d ) ", direita[j]);
        j++;
    }
    for (int i = inicio; i < fim; i++)
    {
        if (esq >= tam)
        {
            lista[i] = direita[dir];
            
            dir++;
        }
        else if (dir >= tam)
        {
            lista[i] = esquerda[esq];
            esq++;
            
            
        }
        else if (esquerda[esq] < direita[dir])
        {

            
            lista[i] = esquerda[esq];
            esq++;
            
        }
        else
        {
            
            lista[i] = direita[dir];
            dir++;
            
        }
        // printf("lista 0: %d ", lista[0]);
    }
    
    printf("\n");
}

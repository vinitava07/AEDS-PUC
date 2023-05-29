#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char *palavra)
{
    bool result = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        result = true;
    }

    return result;
}
bool ehPalin(char* palavra,int i, int j) {
        
         bool palin = true;
        if ((i < strlen(palavra) - 2 / 2)) {
            if (palavra[i] == palavra[j]) {
                palin = ehPalin(palavra, ++i, --j);
            } else {
                palin = false;
            }
        }
        return palin;
        

}

int main()
{
    char palavra[10000];
    fgets(palavra, 10000, stdin);
    while (!isFim(palavra))
    {
        if(ehPalin(palavra,0,strlen(palavra)-2)) {
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
        fgets(palavra, 10000, stdin);
    }

    return 0;
}

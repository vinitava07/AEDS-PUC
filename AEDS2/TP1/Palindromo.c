#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <strings.h>

bool isFim(char *palavra)
{
    bool result = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        result = true;
    }

    return result;
}
void ehPalin(char* palavra) {

        
        int j = strlen(palavra) - 2;
        int i = 0;
        bool palin = true;
        while(i < strlen(palavra)-2/2 && palin) {
            if (palavra[i] == palavra[j]) {
                j--;
                i++;
            } else {
                palin = false;
            }
        }
        if (palin && !isFim(palavra))
        {
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
        

}

int main()
{
    char palavra[10000];
    fgets(palavra, 10000, stdin);
    while (!isFim(palavra))
    {
        ehPalin(palavra);
        fgets(palavra, 10000, stdin);
    }

    return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool isFim(char *palavra)
{
    bool result = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        result = true;
    }

    return result;
}

bool real(char *s)
{

    bool res = true;
    size_t i = 0;
    int v = 0;
    while (res && i < strlen(s)-1)
    {

        if (s[i] == ',' || s[i] == '.')
        {
            v++;
        }
        if ((s[i] < '0' || s[i] > '9') && s[i] != ',' && s[i] != '.')
        {

            res = false;
        }
        i++;
    }
    if (v > 1)
    {
        res = false;
    }

    return res;
}

bool inteiro(char *s)
{
    bool res = true;
    size_t i = 0;
    while (res && i < strlen(s)-1)
    {

        if (s[i] < '0' || s[i] > '9')
        {

            res = false;
        }
        i++;
    }

    return res;
}

bool consoante(char *s)
{
    bool res = true;
    size_t i = 0;
    while (res && i < strlen(s)-1)
    {

        if ((s[i] < 97) || (s[i] > 122))
        {
            res = false;
        }
        else if (!(s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u'))
        {
            res = false;
        }
        i++;
    }

    return res;
}

bool vogal(char *s)
{

    bool res = true;
    size_t i = 0;
    while (res && i < strlen(s)-1)
    {

        if (s[i] < 97 || s[i] > 122)
        {
            res = false;
        }
        else if (!(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u'))
        {
            res = false;
        }
        i++;
    }
    return res;
}

int main()
{
    char entrada[1000];
    fgets(entrada, 1000, stdin);
    while (!isFim(entrada))
    {
        for (size_t i = 0; i < strlen(entrada); i++)
        {
            entrada[i] = tolower(entrada[i]);
        }
        if (vogal(entrada))
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }
        if (consoante(entrada))
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }
        if (inteiro(entrada))
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }
        if (real(entrada))
        {
            printf("SIM");
        }
        else
        {
            printf("NAO");
        }
        printf("\n");
        fgets(entrada, 1000, stdin);
    }

    return 0;
}

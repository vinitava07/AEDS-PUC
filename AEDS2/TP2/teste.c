#include <stdio.h>
#include <string.h>

int main()
{

    char str[] = "/tmp/personagens/AdiGallia.txt\n"
                 "/tmp/personagens/ArvelCrynyd.txt\n"
                 "/tmp/personagens/BarrissOffee.txt\n"
                 "/tmp/personagens/BeruWhitesunlars.txt\n"
                 "/tmp/personagens/BobaFett.txt\n"
                 "/tmp/personagens/Bossk.txt\n"
                 "/tmp/personagens/C-3PO.txt\n"
                 "/tmp/personagens/C-3PO.txt\n"
                 "/tmp/personagens/Cordé.txt\n"
                 "/tmp/personagens/DarthMaul.txt\n"
                 "/tmp/personagens/DarthVader.txt\n"
                 "/tmp/personagens/Dormé.txt\n"
                 "/tmp/personagens/DudBolt.txt\n"
                 "/tmp/personagens/EethKoth.txt\n"
                 "/tmp/personagens/Finn.txt\n"
                 "/tmp/personagens/GregarTypho.txt\n"
                 "/tmp/personagens/HanSolo.txt\n"
                 "/tmp/personagens/IG-88.txt\n"
                 "/tmp/personagens/LandoCalrissian.txt\n"
                 "/tmp/personagens/LeiaOrgana.txt\n"
                 "/tmp/personagens/Lobot.txt\n"
                 "/tmp/personagens/MaceWindu.txt\n"
                 "/tmp/personagens/Obi-WanKenobi.txt\n"
                 "/tmp/personagens/PadméAmidala.txt\n"
                 "/tmp/personagens/Palpatine.txt\n"
                 "/tmp/personagens/PloKoon.txt\n"
                 "/tmp/personagens/PoeDameron.txt\n"
                 "/tmp/personagens/PoggletheLesser.txt\n"
                 "/tmp/personagens/QuarshPanaka.txt\n"
                 "/tmp/personagens/Qui-GonJinn.txt\n"
                 "/tmp/personagens/R5-D4.txt\n"
                 "/tmp/personagens/Rey.txt\n"
                 "/tmp/personagens/Sebulba.txt\n"
                 "/tmp/personagens/ShaakTi.txt\n"
                 "/tmp/personagens/SlyMoore.txt\n"
                 "/tmp/personagens/Tarfful.txt\n"
                 "/tmp/personagens/TaunWe.txt\n"
                 "/tmp/personagens/TionMedon.txt\n"
                 "/tmp/personagens/WatTambor.txt\n"
                 "/tmp/personagens/Watto.txt\n"
                 "/tmp/personagens/YaraelPoof.txt\n"
                 "/tmp/personagens/Yoda.txt\n"
                 "FIM\n";
    FILE *p1;

    p1 = fopen("pub.in", "w");
    char c1;
    char line[100];
    char *nome_arquivo = strtok(str, "\n");
    while (nome_arquivo != NULL)
    {
        fprintf(p1, "%s\n", nome_arquivo);
        nome_arquivo = strtok(NULL, "\n");
    }
    fclose(p1);

    char c;

    FILE *p;

    p = fopen("pub.in", "r");
    while (!feof(p))
    {
        fscanf(p, "%c", &c);
        printf("%c", c);
    }

    // fclose(s);
    return 0;
}
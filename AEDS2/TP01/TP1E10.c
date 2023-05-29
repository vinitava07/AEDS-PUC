#include <stdio.h>

int main () {
	int n = 0;
	double aux = 0;
	scanf("%d", &n);
	FILE* arquivo = fopen("result", "wb");
	for (int i = 0; i < n; i++) {
		scanf("%lf", &aux);
		fwrite(&aux, sizeof(double), 1, arquivo);
	}
	fclose(arquivo);
	FILE* arquivo2 = fopen("result", "rb");
	fseek(arquivo2, -1*sizeof(double), SEEK_END);
	for (int i=1; i<n; i++){
		fread (&aux, sizeof(double), 1, arquivo2);
		printf("%g\n", aux);
		fseek(arquivo2, -2*sizeof(double), SEEK_CUR);
	}
	fread(&aux, sizeof(double), 1, arquivo2);
	printf("%g\n", aux);
	fclose(arquivo2);
}
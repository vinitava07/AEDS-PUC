import java.util.Scanner;

public class L1ex3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double diaria,desconto,arrecadacao,arrecadacao1,x;
        System.out.println("Digite o valor da diaria: ");
        diaria = sc.nextDouble();
        desconto = diaria - diaria*0.25;//Diaria com desconto
        arrecadacao = (75 * 0.8) * desconto;//Arrecadação da diária com desconto
        arrecadacao1 = (75 * 0.5) * diaria;//Arrecadação da diária normal
        x = arrecadacao - arrecadacao1;//Diferença de arrecadação
        System.out.printf("Valor diaria promocional %.2f\n", desconto);
        System.out.printf("Arrecadado com 80%% de ocupação: %.2f\n", arrecadacao);
        System.out.printf("Arrecadado com 50%% de ocupação: %.2f\n", arrecadacao1);
        System.out.printf("Diferença entre os 2 valores %.2f\n", x);
        sc.close();
    }
    
}

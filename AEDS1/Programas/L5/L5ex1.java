import java.util.Scanner;

public class L5ex1 {

    public static void fill(double[] notas, Scanner sc) {
        System.out.println("Preencha as notas");
        for (int i = 0; i < 10; i++) {
            notas[i] = sc.nextDouble();
        }
    }

    public static void media(double[] notas) {
        double media = 0;
        int x = 0;
        for (int i = 0; i < 10; i++) {
            media += notas[i];
            if(notas[i] >= 6) {
                x++;
            }
        }
        System.out.printf("A média da turma foi: %.2f\n", media/10);
        System.out.printf("O total de pessoas com nota acima da média foi: %d", x);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] notas = new double[10];

        fill(notas, sc);
        media(notas);
        sc.close();

    }

}

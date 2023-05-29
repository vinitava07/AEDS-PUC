import java.util.Scanner;

public class L5ex2 {

    public static void fill(int[] v, Scanner sc) {
        System.out.println("Preencha o vetor: ");
        for (int i = 0; i < 10; i++) {
            v[i] = sc.nextInt();
        }
    }

    public static int[] neg(int[] v) {

        int[] vet = new int[10];

        for (int i = 0; i < 10; i++) {
            if (v[i] < 0) {
                vet[i] = v[i];
            } else {
                vet[i] = 0;
            }
        }
        return vet;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] v = new int[10];
        int[] n;

        fill(v, sc);
        n = neg(v);
        System.out.println("Vetor retornado");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", n[i]);
        }
    }
}

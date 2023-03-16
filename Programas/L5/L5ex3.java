import java.util.Scanner;

public class L5ex3 {

    public static void fill(int[] x, int[] y, Scanner sc) {
        System.out.println("Preencha o vetor X: ");
        for (int i = 0; i < 10; i++) {
            x[i] = sc.nextInt();
        }
        System.out.println("Preencha o vetor Y: ");
        for (int i = 0; i < 10; i++) {
            y[i] = sc.nextInt();
        }
    }

    public static int[] mix(int[] x, int[] y) {
        int[] xy = new int[10];
        for(int i = 0; i < 10 ; i++)
        {
           if(i%2 == 0) {
               xy[i] = x[i];
           }
           else {
            xy[i] = y[i];            
           }
        }
        return xy;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] x = new int[10];
        int[] y = new int[10];
        int[] xy;
        fill(x, y, sc);
        xy = mix(x,y);
        System.out.println("Vetor retornado");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", xy[i]);
        }

    }
}

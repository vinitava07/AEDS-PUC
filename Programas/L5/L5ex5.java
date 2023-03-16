import java.util.Scanner;

public class L5ex5 {

    public static void fill(int[][] m, Scanner sc) {
        System.out.println("Preencha a matriz: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                m[i][j] = sc.nextInt();
            }
        }

    }

    public static int[][] fa(int[][] a, int[][] b) {

        int[][] m = new int[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                m[i][j] = a[i][j] + b[i][j];
            }
        }
        return m;
    }

    public static int[][] fb(int[][] a, int[][] b) {

        int[][] m = new int[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                m[i][j] = a[i][j] - b[i][j];
            }
        }
        return m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] a = new int[4][6];
        int[][] b = new int[4][6];
        int[][] ra;
        int[][] rb;
        fill(a, sc);
        fill(b, sc);
        ra = fa(a, b);
        rb = fb(a, b);

    }

}

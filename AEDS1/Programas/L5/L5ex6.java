import java.util.Scanner;

public class L5ex6 {

    public static void fill(int[][] m, Scanner sc) {
        System.out.println("Preencha a matriz: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                m[i][j] = sc.nextInt();
            }
        }
    }

    public static void show(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%d ", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void fa(int[][] a, int x, int y) {

        int[][] m;
        m = a;
        for (int i = 0; i < 10; i++) {
            a[x][i] = m[y][i];
            a[y][i] = m[x][i];
        }
    }

    public static void fb(int[][] a, int x, int y) {

        int[][] m;
        m = a;
        for (int i = 0; i < 10; i++) {
            a[i][x] = m[i][y];
            a[i][y] = m[i][x];
        }
    }

    public static void fc(int[][] a, int x, int y) {

        int[][] m;
        int j = 9;
        m = a;
        for (int i = 0; i < 10; i++) {
            a[i][i] = m[i][j];
            a[i][j] = m[i][i];
            j--;
        }
    }

    public static void fd(int[][] a, int x, int y) {

        int[][] m;
        m = a;
        for (int i = 0; i < 10; i++) {
            a[x][i] = m[i][y];
            a[y][i] = m[i][x];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] a = new int[10][10];

        fill(a, sc);
        show(a);
        fa(a, 2, 8);
        show(a);
        fb(a, 4, 10);
        show(a);
        fc(a);
        show(a);
        fd(a, 5, 10);
        show(a);
    }

}

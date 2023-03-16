import java.util.Scanner;

public class L5ex4 {

    public static void fill(int[][] m, Scanner sc) {
        System.out.println("Preencha a matriz: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                m[i][j] = sc.nextInt();
            }
        }

    }

    public static int fa(int[][] m) {

        int s = 0;
        for (int i = 0; i < 5; i++) {
            s+= m[4][i];
        }
        return s;
    }

    public static int fb(int[][] m) {
        int s = 0;
        for (int i = 0; i < 5; i++) {
            s+= m[i][2];
        }
        return s;
    }

    public static int fc(int[][] m) {
        int s = 0;
        for (int i = 0; i < 5; i++) {
            s+= m[i][i];
        }
        return s;
    }

    public static int fd(int[][] m) {
        int s = 0;
        int j = 4;
        for (int i = 0; i < 5; i++) {
            s+= m[i][j];
            j--;
        }
        return s;
    }

    public static int fe(int[][] m) {
        int s = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s+= m[i][j];
            }
        }
        return s;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] m = new int[5][5];
        int ra, rb, rc, rd, re;
        fill(m, sc);
        ra = fa(m);
        rb = fb(m);
        rc = fc(m);
        rd = fd(m);
        re = fe(m);

    }

}

import java.util.Scanner;

public class L6ex4 {

    public static int verfPal(StringBuilder frase) {
        int x = 0;
        int y = frase.length() - 1;
        for (int i = 0; i < frase.length() / 2; i++) {//verifica se a palavra é palindromo
            if (frase.charAt(i) == frase.charAt(y)) {
                x++;
            }
            y--;
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        StringBuilder frase;
        System.out.println("Digite sua frase: ");
        frase = new StringBuilder(sc.nextLine());
        int control = frase.length();
        for (int i = 0; i < control; i++) {//tira os espaços
            if (frase.charAt(i) == ' ') {
                control = control - 1;
                for (int j = i; j < control; j++) {
                    frase.setCharAt(j, frase.charAt(j + 1));
                }
                frase.deleteCharAt(control);
                i = 0;
            }
        }
        x = verfPal(frase);
        if (x == frase.length() / 2) {
            System.out.println("A frase ou palavra é um palindromo");
        } else {
            System.out.println("A frase ou palavra não é um palindromo");
        }
        sc.close();
    }

}

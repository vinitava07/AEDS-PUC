import java.util.Scanner;

public class L6ex1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nome;
        StringBuilder iniciais = new StringBuilder();
        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        nome = nome.toUpperCase();
        nome = nome.trim();

        iniciais.append(nome.charAt(0));
        for (int i = 0; i < nome.length(); i++) {

            if (nome.charAt(i) == ' ') {

                if (nome.charAt(i + 1) == 'D' && nome.charAt(i + 2) == 'A' && nome.charAt(i + 3) == ' ') {
                    i = i + 2;
                } else if (nome.charAt(i + 1) == 'D' && nome.charAt(i + 2) == 'E' && nome.charAt(i + 3) == ' ') {
                    i = i + 2;
                } else if (nome.charAt(i + 1) == 'D' && nome.charAt(i + 2) == 'I' && nome.charAt(i + 3) == ' ') {
                    i = i + 2;
                } else if (nome.charAt(i + 1) == 'D' && nome.charAt(i + 2) == 'O' && nome.charAt(i + 3) == ' ') {
                    i = i + 2;
                } else if (nome.charAt(i + 1) == 'D' && nome.charAt(i + 2) == 'U' && nome.charAt(i + 3) == ' ') {
                    i = i + 2;
                } else if (nome.charAt(i + 1) == 'E' && nome.charAt(i + 2) == ' ') {
                    i = i + 1;
                } else {
                    iniciais.append(nome.charAt(i + 1));
                }

            }
        }
        sc.close();
        System.out.println("As iniciais do nome são: "+iniciais);
    }
}
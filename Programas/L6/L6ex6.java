import java.util.Scanner;

public class L6ex6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder frase;
        System.out.println("Digite sua frase: ");
        frase = new StringBuilder(sc.nextLine());
        int control = frase.length();
        for (int i = 0; i < control; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.printf(" ");
                }
                System.out.println(frase.charAt(i));
        }
        sc.close();
    }
    
}

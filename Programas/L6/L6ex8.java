import java.util.Scanner;

public class L6ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        System.out.println("Digite sua frase: ");
        frase = new String(sc.nextLine());
        char[] c = frase.toCharArray();
        int control = frase.length();
        for (int i = 0; i < control; i++) {
                c[i] = (char) (c[i] +3);
        }
        String a = String.valueOf(c);
        System.out.println("Frase codificada: ");
        System.out.println(a);
        sc.close();
}
    
}

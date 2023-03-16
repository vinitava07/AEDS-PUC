import java.util.Scanner;

public class L6ex7 {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String frase;
            System.out.println("Digite sua frase: ");
            frase = new String(sc.nextLine());
            char[] c = frase.toCharArray();
            int control = frase.length();
            for (int i = 0; i < control; i++) {
                if(c[i] >= 'a' && c[i] <='z')
                {
                    c[i] = (char) ((int) c[i] - 32);
                }
            }
            System.out.print("Frase em maiusculo: ");
                for (int i = 0; i < c.length; i++) {
                        System.out.print(c[i]);
                }
            sc.close();
    }
    
}

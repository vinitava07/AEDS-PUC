import java.util.Scanner;

public class L6ex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder frase;
        System.out.println("Digite seu frase: ");
        frase = new StringBuilder(sc.nextLine());
        int control = frase.length();
        for (int i = 0; i < control; i++) {
            if (frase.charAt(i) == ' ' && frase.charAt(i+1) == ' ') {
                control = control - 1;
                for(int j = i; j < control; j++)
                {
                    frase.setCharAt(j, frase.charAt(j+1));
                }
                frase.deleteCharAt(control);   
                i = 0;     
            }
        }
        System.out.println("Frase sem espaços adicionais:");
        System.out.println(frase);
        sc.close();
    }
    
}

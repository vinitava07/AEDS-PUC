import java.util.Scanner;

public class L6ex5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        StringBuilder frase;
        System.out.println("Digite seu telefone: ");
        frase = new StringBuilder(sc.nextLine());
        x = frase.length();
        if(x == 10)
        {
            System.out.println("O telefone está correto");
        }
        else if(x == 9)
        {
            frase.insert(0, '9');
            System.out.println("Telefone corrigido com o 9");
            System.out.println(frase);
        }
        else if(x == 8)
        {
            frase.insert(0, '9');
            frase.insert(5, '-');
            System.out.println("Telefone corrigido com o 9 e a formatação");
            System.out.println(frase);
        }
        sc.close();
    }
    
}

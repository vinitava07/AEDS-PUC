//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;

public class L3ex10 {

    public static char conceito(int idade)
    {
        if(idade >= 5 && idade <=7)
        {
            return 'f';
        }
        else if(idade >= 8 && idade <= 10)
        {
            return 'e';
        }
        else if(idade >= 11 && idade <= 13)
        {
            return 'd';
        }
        else if(idade >= 14 && idade <= 15)
        {
            return 'c';
        }
        else if(idade >= 16 && idade <= 17)
        {
            return 'b';
        }
        else if(idade >= 18)
        {
            return 'a';
        }
        return 'n';
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int idade;
        char categoria;
        System.out.println("Digite a idade do nadador:");
        idade = sc.nextInt();
        categoria = conceito(idade);
        System.out.printf("A categoria do nadador é: %c", categoria-32);
        sc.close();
    }
    
}

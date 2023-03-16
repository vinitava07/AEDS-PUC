//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;

public class L3ex5 {

    public static void conceito(int media)
    {
        if(media <= 39)
        {
            System.out.println("Conceito: F");
        }
        else if(media >= 40 && media <= 59)
        {
            System.out.println("Conceito: E");
        }
        else if(media >= 60 && media <= 69)
        {
            System.out.println("Conceito: D");
        }
        else if(media >= 70 && media <= 79)
        {
            System.out.println("Conceito: C");
        }
        else if(media >= 80 && media <= 89)
        {
            System.out.println("Conceito: B");
        }
        else
        {
            System.out.println("Conceito: A");
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, media;
        System.out.println("Digite N:");
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            System.out.println("Digite a média do aluno:");
            media = sc.nextInt();
            conceito(media);
        }
        sc.close();
    }
    
}

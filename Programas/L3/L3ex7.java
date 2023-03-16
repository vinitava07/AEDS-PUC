//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;

public class L3ex7 {

    public static boolean positivo(int x)
    {
        if(x >= 0)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n,x;
        boolean a;

        System.out.println("Digite N ");
        n = sc.nextInt();
        for(int i = 0; i< n; i++)
        {
            System.out.println("Digite um número inteiro: ");
            x = sc.nextInt();
            a = positivo(x);
            if(a)
            {
                System.out.println("O valor é positivo");
            }
            else
            {
                System.out.println("O valor é negativo");
            }
        }
        sc.close();
    }
}

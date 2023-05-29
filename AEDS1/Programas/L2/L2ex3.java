import java.util.Scanner;

public class L2ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        float y = 0;
        float fatorial = 1;
        System.out.println("Digite N ");
        n = sc.nextInt();
        if (n>=0)
        {
            for(int i = 1; i<= n; i++)
            {
                for(int j = 1; j < i; j++)
                {
                    fatorial = fatorial * j;//faz o fatorial do numero
                }
                y = y + (1/fatorial);//faz o somatorio desejado
                fatorial = 1;// reinicia o fatorial para que possa ser feito novamente
            }
            System.out.printf("O resultado do somatório é: %f, aproximação do numero de euler",y);
        }
        else
        {
            System.out.println("Digite um inteiro positivo");
        }
        sc.close();
    }
    
}

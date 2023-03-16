import java.util.Scanner;
//Vinícius Tavares Coimbra Ribeiro
public class L1ex5 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double total = 0,n;
        System.out.println("Digite o numero N: (maior que 0)");
        n = sc.nextInt();
        for(double i = 1; i<=n;i++)//For do somatório 1 + 1/2 ... 1/n
        {
            total = total + 1/i;
        }
        System.out.println("O resultado é: " +total);
        sc.close();
    }
    
}

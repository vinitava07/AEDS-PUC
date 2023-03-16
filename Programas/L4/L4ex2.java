import java.util.Scanner;

public class L4ex2 {

    public static int div(int n,int d)
    {
        if((n-d) == 0)
        {
            return 1;
        }
        else if((n-d) < 0)
        {
            System.out.println("O resto é: " +(n));//printa o resto
            return 0;
        }
        return 1 + div((n-d),d);// faz a somatoria do numero de vezes que foi possível subtrair
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n,d,x;

        System.out.println("Digite o numerador: ");
        n = sc.nextInt();
        System.out.println("Digite o denominador: ");
        d = sc.nextInt();
        x = div(n,d);
        System.out.println("Resultado da divisão: "+x);
        sc.close();
        
    }
    
}

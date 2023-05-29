import java.util.Scanner;

public class L4ex3 {

    public static int div(int n,int d)
    {
        if((n-d) == 0)
        {
            return 0;//retorna 0 para divisão perfeita
        }
        else if((n-d) < 0)
        {
            return n;//retorna o resto
        }
        return 0 + div((n-d),d);
        
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n,d,x;

        System.out.println("Digite o numerador: ");
        n = sc.nextInt();
        System.out.println("Digite o denominador: ");
        d = sc.nextInt();
        x = div(n,d);
        System.out.println("O resto é: "+x);
        sc.close();
        
    }
    
}

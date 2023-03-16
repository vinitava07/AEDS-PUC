import java.util.Scanner;

public class L4ex4 {

    public static int div(int n,int d)
    {
        if(n<d)
        {
            return n;//retorna o resto
        }
        else if(n == d)
        {
            return 0;//retorna 0 caso a divisão seja perfeita
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

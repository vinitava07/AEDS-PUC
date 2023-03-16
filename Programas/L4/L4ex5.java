import java.util.Scanner;

public class L4ex5 {

    public static double serie(double n)
    {
       double fatorial = 1;
       if(n <= 0)
        {
            return 0;
        }
        for(int i = 1; i <= n; i++) {
            fatorial *= i;//calcula fatorial
        }
        return (1/fatorial) + serie(n-1);//soma do 1/fatorial + 1/fatorial da passada
        
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double n;
        double x;

        System.out.println("Digite o numero: ");
        n = sc.nextDouble();
        x = serie(n);
        System.out.println("O total é: "+x);
        sc.close();
        
    }
    
}

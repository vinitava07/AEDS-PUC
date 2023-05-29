import java.util.Scanner;

public class L2ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1;
        int y = 0;
        int a = 0,b = 1;
        System.out.println("Digite L ");
        n = sc.nextInt();
        while (y < n)//loop irá parar quando a soma for menor que o digitado
        {
            System.out.printf("O número %d da sequencia menor que %d de fibonacci é: %d\n",i,n,y);
            y = a + b;//soma dos 2 numeros n + n-1
            b = a;//substituição do proximo numero pelo anterior n = n-1
            a = y;//substituição do 2 numero pela soma dos 2 numeros n = n + n-1
            i++;
        }
        sc.close();
    }
    
}
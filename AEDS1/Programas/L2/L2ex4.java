import java.util.Scanner;

public class L2ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int y = 0;
        int a = 0,b = 1;
        System.out.println("Digite L ");
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
        {
            System.out.printf("O número %d da sequencia de fibonacci é: %d\n",i,y);
            y = a + b;//soma dos 2 numeros n + n-1
            b = a;//substituição do proximo numero pelo anterior n = n-1, garantido que nos 3 primeiros loops a sequência respeite a série pois o B irá para 0 novamente
            a = y;//substituição do 2 numero pela soma dos 2 numeros n = n + n-1
        
        }
        sc.close();
    }
    
}

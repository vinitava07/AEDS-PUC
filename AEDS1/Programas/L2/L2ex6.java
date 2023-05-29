import java.util.Scanner;

public class L2ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float x,y;
        int a = 0, b = 0, c = 0;
        float totalc = 0;
        float totalv = 0;
        float totall = 0;
        float lucro = 0;
        System.out.println("Digite o preço de compra:");
        x = sc.nextFloat();
        System.out.println("Digite o preço de venda:");
        y = sc.nextFloat();
        while (y != 0)//se a venda for diferente de 0 o loop continua rodando
        {
            lucro  = y - x;
            if(lucro < (0.1*x))//if para calcular se o lucro atende as condições requeridas das procentagens
            {
                a++;
            }
            else if(lucro >= (0.1*x) && lucro <= (0.2*x)) 
            {
                b++;
            }
            else
            {
                c++;
            }
            totalc += x;
            totalv += y;
            totall += lucro;
            System.out.println("Digite o preço de compra:");
            x = sc.nextFloat();
            System.out.println("Digite o preço de venda:");
            y = sc.nextFloat();
        }
        System.out.printf("Mercadorias com lucro acima de 10%%: %d\n", a);
        System.out.printf("Mercadorias com lucro acima de 10%% e menores que 20%%: %d\n", b);
        System.out.printf("Mercadorias com lucro acima de 20%%: %d\n", c);
        System.out.printf("Total de Compra: %.2f\n", totalc);
        System.out.printf("Total de Venda: %.2f\n", totalv);
        System.out.printf("Total de Lucro: %.2f\n", totall);
        sc.close();
    }
    
}
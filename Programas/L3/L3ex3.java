//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Arrays;
import java.util.Scanner;

public class L3ex3 {

    public static void sort(int[] x)
    {
        Arrays.sort(x);
        System.out.println("Números em ordem crescente: ");
        for(int j = 0; j < 3; j++)
        {
            System.out.printf("Número de posição %d: \n",j+1);
            System.out.println(+x[j]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] x = new int[3];
        int n;
        System.out.println("Digite N:");
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.printf("Digite o número %d\n",j+1);
                x[j] = sc.nextInt();
            }
            sort(x);
        }
        sc.close();
        
    }
}
